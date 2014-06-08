package bg.obshtestvo.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.lucene.search.Query;
import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.impl.FullTextSessionImpl;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.obshtestvo.model.Item;
import bg.obshtestvo.repository.ItemRepository;

@Component
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	EntityManagerFactory emf;
	
	@Resource
	ItemRepository itemRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Item> findItems(String searchString) {
		List<Item> resultList = new ArrayList<Item>();
		EntityManagerFactory factory = emf;
		EntityManager em = factory.createEntityManager();
		FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
		Session session = (Session) fullTextEntityManager.getDelegate();
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		
		Transaction transaction = fullTextSession.beginTransaction();
		fullTextSession.setFlushMode(FlushMode.MANUAL);
		fullTextSession.setCacheMode(CacheMode.IGNORE);
		ScrollableResults results = fullTextSession.createCriteria( Item.class )
			    .setFetchSize(20)
			    .scroll( ScrollMode.FORWARD_ONLY );
			int index = 0;
			while( results.next() ) {
			    index++;
			    fullTextSession.index( results.get(0) ); //index each element
			    if (index % 20 == 0) {
			    	fullTextSession.flushToIndexes(); //apply changes to indexes
			    	fullTextSession.clear(); //free memory since the queue is processed
			    }
			}
			transaction.commit();
		
		em.getTransaction().begin();
		
		QueryBuilder qb = fullTextEntityManager.getSearchFactory()
				.buildQueryBuilder().forEntity(Item.class).get();
		Query query = qb.keyword().fuzzy()
				.onFields("tags", "alias").ignoreFieldBridge().matching(searchString).createQuery();
		FullTextQuery ftq = fullTextEntityManager.createFullTextQuery(query, Item.class);
		resultList = ftq.getResultList();
		em.getTransaction().commit();
		em.close();
		
		return resultList;
	}

	@Override
	public void createOrUpdateItem(Item item) {
		itemRepository.save(item);
	}

	@Override
	public void removeItem(Long itemId) {
		itemRepository.delete(itemId);
	}

}
