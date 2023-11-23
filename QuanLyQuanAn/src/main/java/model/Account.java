package model;

import java.util.ArrayList;
import java.util.List;

import lombok.*;
import org.springframework.stereotype.Component;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Data
@Entity(name="Account")
@Table(name="account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String password;
	
	@Column(length = 1)
	private boolean typeA;
	
	@ManyToMany(mappedBy = "lAccount", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Role> lRole = new ArrayList<Role>();

}
