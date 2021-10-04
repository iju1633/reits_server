package com.example.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table
public class Reits {

	@Id
	@SequenceGenerator( // DB에 데이터마다 번호 붙여지는 효관
			name = "reits_sequence",
			sequenceName = "reits_sequence",
			allocationSize = 1
	)
	@GeneratedValue( // 확실히 이해 못함
			strategy = GenerationType.SEQUENCE,
			generator = "reits_sequence"
	)
	String type;	// 종목명

	String price;	// 현재가 
	String pcr;		// 등락률 
	String pcp; 	// 등락가 
	String volume;	// 거래량

	public Reits() {
	}

	public Reits(String type, String price, String pcr, String pcp, String volume) {
		this.type = type;
		this.price = price;
		this.pcr = pcr;
		this.pcp = pcp;
		this.volume = volume;
	}

	public Reits(String price, String pcr, String pcp, String volume) {
		this.price = price;
		this.pcr = pcr;
		this.pcp = pcp;
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Reits{" +
				"type='" + type + '\'' +
				", price='" + price + '\'' +
				", pcr='" + pcr + '\'' +
				", pcp='" + pcp + '\'' +
				", volume='" + volume + '\'' +
				'}';
	}
}
