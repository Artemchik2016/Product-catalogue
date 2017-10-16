package com.catalogue.product.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "product")
public class Product implements Serializable {

	public Product() {
	}

	public Product(String name, String description, BigDecimal price) {
		this.name = name;
		this.description = description;

		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name="name", nullable=false)
	private String name;

    @Column(name = "description", nullable=true, columnDefinition="VARCHAR(255)")
	private String description;

	@Column(name="price", nullable=false)
	private BigDecimal price;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


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
		return result;
	}
}
