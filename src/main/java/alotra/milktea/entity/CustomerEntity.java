package alotra.milktea.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customer")
public class CustomerEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long customerID;
	
	@NotNull
	@Length(min=5,max=50)
	@Column(name="name")
	private String customerName;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="userName")
	private UserEntity user;
	
	@Length(max=10)
	@Column(name="phone")
	private String phone;
}
