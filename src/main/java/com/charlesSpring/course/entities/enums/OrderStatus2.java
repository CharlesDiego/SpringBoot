package com.charlesSpring.course.entities.enums;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

// @Enumerated (EnumType.STRING) 
//(uma maneira de deixar na tabela com o nome em vez de numeros)

public enum OrderStatus2 {
	
	WAITTING_PAYMENT,
	PAID,
	SHIPPED,
	DELIVERED,
	CANCELED;



		
}