package com.flight.jsf.avion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import pojo.TerminalGejt;
import controller.*;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CollectorView implements Serializable {
    
    private String code;
    
    
    
    
    

    private Book book;

    private List<Book> books;
    private TerminalGejt tt= new TerminalGejt();
    

    @PostConstruct
    public void init() {
        book = new Book();
        books = new ArrayList<Book>();

    }

    public TerminalGejt getTt() {
        return tt;
    }

    public void setTt(TerminalGejt tt) {
        this.tt = tt;
    }
    

    public void createNew() {
        if (books.contains(book)) {
            FacesMessage msg = new FacesMessage("Dublicated", "This book has already been added");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            books.add(book);
            book = new Book();
        }
    }

    public String reinit() {
        book = new Book();

        return null;
    }

    public Book getBook() {
        return book;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String cadastrar() {
        

        for (Book item : books) {
            TerminalGejtDAO inserir = new TerminalGejtDAOImpl();
            TerminalGejt usuario = new TerminalGejt();
            usuario.setGejt(item.getGejt());
            usuario.setTerminal(item.getTerminal());
            usuario.setAirport(code);
            inserir.persist(usuario);
            
        }
        //**ovo sam dodala za button Dodaj
       // clear();
        books=new ArrayList<Book>();
        return "/administrator/addAirport.xhtml?faces-redirect=true";

        
    }
   
    
    
    public void action(){
	   code = FacesContext.getCurrentInstance().
		getExternalContext().getRequestParameterMap().get("hidden1");
           
	}
}
