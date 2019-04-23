package br.eti.webstuff.api.jpa.utils;



import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;



public class OrderList {
	
	
	public static Sort ordenaListaPorParametro(String param){
		
		Order orderAscendente = new Order(Direction.ASC, param);
		Sort sort = new Sort(orderAscendente);
	
		return sort;
	}
}
