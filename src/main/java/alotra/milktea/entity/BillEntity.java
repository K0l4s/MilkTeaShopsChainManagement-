package alotra.milktea.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="bill")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "customerid")
	private CustomerEntity customer;
	
	@ManyToOne
	@JoinColumn(name="employeeid")
	private EmployeeEntity employee;

	@Column(name="createday")
	private LocalDateTime createDay;
}
