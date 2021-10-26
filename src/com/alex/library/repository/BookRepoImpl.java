package com.alex.library.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.alex.library.model.Book;

@Stateless
public class BookRepoImpl implements BookRepo {
	@PersistenceContext(unitName = "mysqlPU")
	private EntityManager em;
	static Logger logger = Logger.getLogger(BookRepoImpl.class);

	@Override
	public Book getBookById(Long id) {
		return em.find(Book.class, id);
	}

	@Override
	public Book getBookByTitle(String title) {
		Query q = em.createQuery("SELECT b FROM Book b WHERE b.title = :title", Book.class);
		q.setParameter("title", title);
		if (q.getResultList().isEmpty())
			return null;
		return (Book) q.getSingleResult();
	}

	@Override
	public Book saveBook(Book b) {
		em.persist(b);
		return b;
	}

	@Override
	public void deleteBook(Long id) {
		Book book = getBookById(id);
		em.remove(book);
	}

	@Override
	public Book updateBook(Book b) {
		em.merge(b);
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAuthorBooks(String author) {
		Query query = em.createQuery("SELECT b FROM Book b WHERE b.author = :author",Book.class);
		query.setParameter("author", author);
		if(query.getResultList().isEmpty())return null;
		else return (List<Book>) query.getResultList();
	}

}
