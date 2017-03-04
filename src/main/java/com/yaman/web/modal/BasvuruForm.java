/**
 * 
 */
package com.yaman.web.modal;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.yaman.web.custom.IsValidTc;





/**
 * @author Arif
 *
 */
public class BasvuruForm {
	@NotEmpty(message="Ad Soyad Boş olamaz")
	@Size(min=10,max=60,message="Ad Soyad 10 ile 60 karakter arasında olmalıdır")
	private	String adsoyad;
	
	
	@NotNull(message="TC Boş olamaz")
	@Range(min=10000000000l, max=99999999999l,message="TC 11 numaradan oluşmalıdır")
	@IsValidTc	//custom annotiation, constraint oluşturulmuştur geçerli bir tc numarası olup olmadığı kontrol edilir
	private Long tc;
	
	@NotEmpty(message="Adres Boş olamaz")
	@Size(min=10,max=60,message="Adres 10 ile 200 karakter arasında olmalıdır")
	private String adres;
	
	@NotEmpty(message="Telefon Boş olamaz")
	@Size(min=5,max=20,message="Telefon 5 ile 20 karakter arasında olmalıdır")
	@Pattern(message="Telefon numarası rakamlardan oluşmalı", regexp="^[+]((([0-9]+) [(][0-9]+[)]) ([0-9]+)[-]([0-9]+))|([0-9]+){1,12}$") //buray� g�zden ge�ir daha sonra 
	private String telefon;
	
	@NotEmpty(message="E-posta Boş olamaz")
	@Email(message="Geçerli bir E-posta adresi girmelisiniz")
	@Size(min=10,max=50,message="E-Posta 10 ile 50 karakter arasında olmalıdır")
	private String eposta;
	
	@NotNull(message="Doğum Tarihi Boş olamaz")
	@Past(message="Doğum Tarihi bugünün öncesi olmalı")
	private Date dtarih;
	
	//on veya off dışında bir değer verilse null olur database e eklenirken 1 dışındaki herşey 0 olacağından kontrol etmedim
	private Boolean is_parakende;
	
	@NotEmpty(message="Tercih nedeni Boş olamaz")
	@Size(min=10,max=200,message="Tercih nedeni 10 ile 300 karakter arasında olmalıdır")
	private String tercih_neden;
	
	@NotEmpty(message="Bir il seçmelisiniz")
	@Size(min=2,max=20,message="İl ile 20 karakter arasında olmalıdır")	
	private String tercih_il;
	
	@NotEmpty(message="Bir ilçe seçmelisiniz")
	@Size(min=2,max=20,message="İlçe ile 20 karakter arasında olmalıdır")	
	private String tercih_ilce;
	
	
	@NotEmpty(message="Bir semt girmelisiniz")
	@Size(min=2,max=20,message="Semt 2 ile 20 karakter arasında olmalıdır")	
	private String tercih_semt;
	
	@NotNull(message="Yatırım miktarınızı belirtmelisiniz")
	@Range(min=0,message="Yatırım miktarınızı pozitif sayılardan oluşmalı")
	private int yatirim;
	
	@Size(max=300,message="Eklemek istedikleriniz en fazla 300 karakter olabilir")	
	private String ekstra;
	
	
	
	
	public String  getAdsoyad(){
		return this.adsoyad;
	}
	
	public void setAdsoyad(String adsoyad) {
		this.adsoyad=adsoyad;
	}
	
	
	public Long  gettc(){
		return this.tc;
	}
	
	
	public void settc(Long tc) {
	
		this.tc=tc;
		
	}
	
	public String getadres() {
		return adres;
	}
	

	public void setadres(String adres) {
		this.adres=adres;
	}
	
	public String gettelefon() {
		return telefon;
	}
	

	public void settelefon(String telefon) {
		this.telefon=telefon;
	}
	
	public String geteposta() {
		return eposta;
	}
	

	public void seteposta(String eposta) {
		this.eposta=eposta;
	}
	
	public Date getdtarih() {
		return dtarih;
	}
	

	public void setdtarih(Date dtarih) {
		this.dtarih=dtarih;
	}
	
	public boolean getis_parakende() {
		if(is_parakende==null)return false;
		
		return is_parakende;
	}
	

	public void setis_parakende(boolean is_parakende) {
		if(is_parakende)
		this.is_parakende=true;
		else
			is_parakende=false;
	}
	
	public void settercih_neden(String tercih_neden) {
		this.tercih_neden=tercih_neden;
	}
	
	public String gettercih_neden() {
		
		return tercih_neden;
	}
	
	public void settercih_il(String tercih_il) {
		this.tercih_il=tercih_il;
	}
	
	public String gettercih_il() {
		return tercih_il;
	}
	
	public void settercih_ilce(String tercih_ilce) {
		this.tercih_ilce=tercih_ilce;
	}
	
	public String gettercih_ilce() {
		return tercih_ilce;
	}
	
	public void settercih_semt(String tercih_semt)  {
		this.tercih_semt=tercih_semt;
		
	}
	
	public String gettercih_semt() {
		return tercih_semt;
	}
	
	public void setyatirim(int yatirim) {
		this.yatirim=yatirim;
	}
	
	public int getyatirim() {
		return yatirim;
	}
	
	public String getekstra() {
		return ekstra;
	}
	
	public void setekstra(String ekstra) {
		this.ekstra=ekstra;
	}
	
	
	
	
	
	
	boolean is_valid_tc(Long tc){
		
		return true;
	}
	
	
	
	
	

	
	
	
	
	public String toString() {
		return adsoyad+" "+tc+" "+adres+" "+telefon+" "+eposta+" "+dtarih+" "+is_parakende+" "+tercih_neden+" "+
				tercih_il+" "+tercih_ilce+" "+tercih_semt+" "+yatirim+" "+ekstra+" ";
	}
}
