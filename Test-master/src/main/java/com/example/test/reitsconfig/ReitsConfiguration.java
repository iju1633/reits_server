package com.example.test.reitsconfig;

import com.example.test.model.Reits;
import com.example.test.repository.ReitsRepository;
import org.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class ReitsConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(ReitsRepository repository) {
        return args -> {
            String url = "https://www.paxnet.co.kr/stock/infoStock/themaView?schThemaCode=0310";

            try {

                JSONArray reitsList = new JSONArray();
                Document doc = Jsoup.connect(url).get();

                Element table = doc.select(".table-data > tbody").get(1);
                Elements trs = table.select("tr");


                Reits reits;
                for(int i = 0; i < trs.size(); i++) {
                    reits = new Reits();
                    // 종목명
                    Element tr = trs.get(i);
                    Elements a = tr.select("td > strong > a");
                    reits.setType(a.text());

                    Elements tds = tr.select(".a-right");
                    String price = tds.get(0).text();
                    String pcr = tds.get(1).text();
                    String pcp = tds.get(2).text();
                    String volume = tds.get(3).text();

                    reits.setPrice(price);
                    reits.setPcr(pcr);
                    reits.setPcp(pcp);
                    reits.setVolume(volume);

                    repository.saveAll(List.of(reits));
                }
            }
            catch (Exception e) {
                // TODO: handle exception
            }
        };
    }
}
