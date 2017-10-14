package com.catalogue.product.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "product")
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name="name", nullable=false)
	private String name;

    @Column(name="price", nullable=false)
	private BigDecimal price;

    @Column(name="quantity", nullable=false)
    private Integer quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	

	@Override
	public boolean equals(Object that) {
		if ( this == that ) return true;
	  if ( !(that instanceof Product) ) return false;
	  
	  Product product = (Product)that;
	  return this.id != null && this.id.equals(product.id);
	}


	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + name.hashCode();
		result = 31 * result + price.hashCode();
		result = 31 * result + quantity.hashCode();
		return result;
	}
}
