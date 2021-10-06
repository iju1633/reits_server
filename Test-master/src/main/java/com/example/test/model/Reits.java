package com.example.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table
public class Reits {

	@Id
	// 아래거 없으니까 table을 찾지 못함(reits 없음, 무시함)
	@SequenceGenerator( // DB에 데이터마다 번호 붙여지는 효관
			name = "reits_sequence",
			sequenceName = "reits_sequence",
			allocationSize = 1
	)
	@GeneratedValue( // 확실히 이해 못함
			strategy = GenerationType.SEQUENCE,
			generator = "reits_sequence"
	)
	@GenericGenerator(name="reits_sequence", strategy = "uuid")
	private String type;	// 종목명

	private String price;	// 현재가
	private String pcr;		// 등락률
	private String pcp; 	// 등락가
	private String volume;	// 거래량

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
