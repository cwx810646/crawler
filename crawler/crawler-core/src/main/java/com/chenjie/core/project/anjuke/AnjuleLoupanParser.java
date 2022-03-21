package com.chenjie.core.project.anjuke;

import com.chenjie.core.parser.Parser;
import org.jsoup.Jsoup;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AnjuleLoupanParser implements Parser<Loupan> {
	private String html; 
	
	public AnjuleLoupanParser(String html) { 
		this.html = html;
	} 

	@Override
    public Loupan parse() {
        if (StringUtil.isBlank(html)) return null;
        Loupan loupan = new Loupan(); 
        Document document = Jsoup.parse(html);
        Elements nameElement = document.select(".basic-details .basic-info h1");
        String name = nameElement.text();
        loupan.setName(name);

        Elements aliasElement = document.select(".basic-details .basic-info .lp-alias");
        String alias = aliasElement.text();
        loupan.setAlias(alias);

        Elements lpTypeElement = document.select(".basic-details .basic-info .lp-type");
        String lpType = lpTypeElement.text();
        loupan.setLpType(lpType);

        Elements saleElement = document.select(".basic-details .basic-info .on-sale");
        String sale = saleElement.text();
        loupan.setSale(sale);

        Elements descElement = document.select(".basic-details .basic-info a[title]");
        String desc = descElement.text();
        loupan.setDesc(desc);

        Elements priceElement = document.select(".basic-details .basic-parms dd:eq(1) em");
        String price = priceElement.text();
        loupan.setPrice(price);

        Elements openTimeElement = document.select(".basic-details .basic-parms dd:eq(3) span");
        String openTime = openTimeElement.text();
        loupan.setOpenTime(openTime);

        Elements checkTimeElement = document.select(".basic-details .basic-parms dd:eq(5) span");
        String checkTime = checkTimeElement.text();
        loupan.setCheckTime(checkTime);

        Elements addressElement = document.select(".basic-details .basic-parms dd:eq(9) .lpAddr-text");
        String address = addressElement.text();
        loupan.setAddress(address)  ;
        return loupan;
    }
}
