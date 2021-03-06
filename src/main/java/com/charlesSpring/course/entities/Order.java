package com.charlesSpring.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.charlesSpring.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Instant moment;
	
	private Integer orderStatus;
	
	
	@ManyToOne	
	@JoinColumn(name = "client_id")
	private User client;
	
	@OneToMany(mappedBy =  "id.order")
	private Set<OrdemItem> itens = new HashSet<>();
	
	
	@OneToOne(mappedBy ="order", cascade = CascadeType.ALL)
	private Payment payment;
	
	
	public Order () {
		
	}
	

	public Order(Long id, Instant moment,OrderStatus orderStatus ,User client) {
		super();
		this.id = id;
		this.moment = moment;
		setOrderStatus (orderStatus);
		this.client = client;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd't'HH:mm:ss'Z'", timezone ="GMT")
	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	@JsonIgnore
	public User getCliente() {
		return client;
	}

	public void setCliente(User cliente) {
		this.client = cliente;
	}


	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOff (orderStatus);
	}


	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null)
		this.orderStatus = orderStatus.getCode();
	}

	public Set<OrdemItem> getItens() {
		return itens;
	}
	
	@JsonIgnore
	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	 public Double getTotal() {
		 double sum = 0.0;
		 for (OrdemItem x : itens) {
			 sum= sum + x.getSubTotal();
		 }
		 return sum;
	 }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
 
}
