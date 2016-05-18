package gingko.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import gingko.entity.Book;
import gingko.repository.BookRepository;

@Service
public class SearchService {

	@Autowired
	private BookRepository bookRepository;

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Book> find(String SearchService){
		return bookRepository.findAll(); 
	}


	public Map<String, Object> search(String search, int page, String view, String sort) {
		
		
		List<Book> books = null;
		
		String hql = "select book from Book book" +
//						" join book.authors author where author.id = :author_id" +
						" join book.genre genre" +
						" where 1=1";
			hql += " and lower(book.title) like :search"; 
//			hql += " or lower(author.name) like :search";
			hql += " or lower(genre.name) like :search";
			hql += " or lower(book.isbn) like :search";
		
		Direction orderDirection = Direction.ASC;	
			
		if (sort != null){
			if("title".equals(sort)){
				hql += " order by";
				hql += " " + sort ;
				hql += " " + orderDirection;
			}
		}

		TypedQuery<Book> query = entityManager.createQuery(hql, Book.class);
		query.setParameter("search", "%"+search+"%");
		
		int booksFound = query.getResultList().size();
		int pageSize = 1;
		int lastPage = (booksFound / pageSize) -1;
		
		books = query.setFirstResult(page * pageSize).setMaxResults(pageSize).getResultList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("books", books);
		map.put("booksFound", booksFound);
		map.put("lastPage", lastPage);
		return map;
	}
	
	public List<Book> advancedSearch(String title, String author, String genre, String isbn, int page) {
		// TODO Auto-generated method stub
		return null;
	}


}
