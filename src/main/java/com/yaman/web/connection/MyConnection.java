package com.yaman.web.connection;

/**
 * @author Arif
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.yaman.web.modal.BasvuruForm;
import com.yaman.web.modal.BootstrapModal;
import com.yaman.web.modal.BootstrapModal.ModelType;


public class MyConnection {
	private DriverManagerDataSource datasource;
	BootstrapModal bootstrapModal;
	private boolean fix_problems;
	
	public MyConnection() throws BootstrapModal {
		datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/lokumcubaba?useUnicode=yes&characterEncoding=UTF-8");
		datasource.setUsername("root");
		datasource.setPassword("");
		fix_problems=true; //tablo ve veri tabanı eksikleri varsa initialize edilirken düzeltme kontrolü
		bootstrapModal=new BootstrapModal();
		
		init_conection();
	}
	
	
	private void init_conection() throws BootstrapModal {
				try {
					Connection connection= datasource.getConnection();
					Statement statement=connection.createStatement();
					statement.executeQuery("SELECT 1 FROM onbasvuruform LIMIT 1;");
					//başarabiliyorsa modal göstermeye gerek yoktur. gizlenir ve throw edilir.
					bootstrapModal.hidden();
					connection.close();
						
				} catch (SQLException e) {
					if(fix_problems){
						if(e.getErrorCode()==1049){//database yok demektir fix_problems true ise oluşturulur.
							e.printStackTrace();
							bootstrapModal.setTitle("SQL Hatası").setBody(e.getMessage()+"   "+e.getErrorCode());
							create_database("lokumcubaba", "utf8", "utf8_general_ci");
							//veritabanı yoksa tablo da yok demektir. Oluşturulur.
							create_onbasvuruform_table();
						}else if(e.getErrorCode()==1146){//tablo yok demektir. fix_problems true ise oluşturulur.
							bootstrapModal.add_to_body(e.getMessage()+"   "+e.getErrorCode());
							create_onbasvuruform_table();
						}else	//veritabanı ve tablo problemi değilse server, mysql portu veya kullanıcı problemidir. 
					throw bootstrapModal.setTitle("SQL Hatası").setBody(e.getMessage()+"   "+e.getErrorCode()).add_to_body("-com.yaman.web.connection.MyConnection.java içerisinde mysql portu ve kullanıcı bilgilerini kontol edin. Serverin açık olduğundan emin olun");
					
					}else //fix_problem false olduğu için aldığı ilk SQL hatasını throw eder.
						throw bootstrapModal.setTitle("SQL Hatası").setBody(e.getMessage()+"   "+e.getErrorCode());
				
					/*
					 * Problemler düzeltilirken bootstrap modal içine gerekli bilgilendirmeler gömüşmüştür throw edilir.
					 */
					throw bootstrapModal;
				}
	}
	
	private void create_onbasvuruform_table() throws BootstrapModal {
		try {
			Connection connection=datasource.getConnection();
			bootstrapModal.setType(ModelType.Info).add_to_body("-onbasvuruform tablosu oluşturuldu").setTitle("Sorunlar Çözüldü");
			Statement statement=connection.createStatement();
			statement.executeUpdate("CREATE TABLE `lokumcubaba`.`onbasvuruform` ( `id` SERIAL NOT NULL AUTO_INCREMENT , `adsoyad` VARCHAR(60) NOT NULL , `tc`  BIGINT(11) NOT NULL UNIQUE , `adres` VARCHAR(200) NOT NULL , `telefon` VARCHAR(20) NOT NULL , `eposta` VARCHAR(50) NOT NULL , `dtarih` DATE NOT NULL , `is_parakende` BOOLEAN NOT NULL , `tercih_neden` VARCHAR(300) NOT NULL , `tercih_il` VARCHAR(20) NOT NULL , `tercih_ilce` VARCHAR(20) NOT NULL , `tercih_semt` VARCHAR(20) NOT NULL , `yatirim` INT NOT NULL , `ekstra` VARCHAR(300) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB CHARSET=utf8 COLLATE utf8_turkish_ci;");
			
			connection.close();
		} catch (SQLException e) {
			//tablo oluşturulamazsa thow edilir ekranda gösterilir.
			throw bootstrapModal.setTitle("SQL Hatası").setBody(e.getMessage()+"   "+e.getErrorCode()).setType(ModelType.Error);
		}
	}
	
	protected void create_database(String dbname, String char_set,String collation) throws BootstrapModal {
		try {
			datasource.setUrl("jdbc:mysql://localhost:3306");
			Connection connection=datasource.getConnection();
			/*
			 * PreparedStatement setString methoduyla gömemediğim için drek ekledim
			 * Belki sonraki projelerde de kullanabileceğimden parametre alarak çalıştırdım
			 * Bir kullanıcı girişi gerekmediğinden SQL Injection yapılamaz.
			 * 
			 */
			PreparedStatement ps = connection.prepareStatement("CREATE DATABASE "+dbname+" CHARACTER SET "+char_set+" COLLATE "+collation+";");
			ps.execute();
			bootstrapModal.setType(ModelType.Info).add_to_body("-"+dbname+" veri tabanı oluşturuldu").setTitle("Sorunlar Çözüldü");
			connection.close();
		} catch (SQLException e) {
			//veri tabanı oluşturulamazsa thow edilir ekranda gösterilir.
			throw bootstrapModal.setTitle("SQL Hatası").setBody(e.getMessage()+"   "+e.getErrorCode());
		}
	}
	
	
	public void addBasvuruForm(BasvuruForm basvuruForm) throws BootstrapModal {
		try {
			Connection connection=datasource.getConnection();
			
			PreparedStatement statement=
			connection.prepareStatement("INSERT INTO `onbasvuruform` ( `adsoyad`, `tc`, `adres`, `telefon`, "
					+ "`eposta`, `dtarih`, `is_parakende`, `tercih_neden`, `tercih_il`, `tercih_ilce`, `tercih_semt`"
					+ ", `yatirim`, `ekstra`)"
					+ " VALUES (?, ?, ?"
					+ ", ?, ?, ?, ?, ?,"
					+ " ?, ?, ?, ?, ?)");
			
			statement.setString(1, basvuruForm.getAdsoyad());		
			statement.setString(2, basvuruForm.gettc());
			statement.setString(3, basvuruForm.getadres());
			statement.setString(4, basvuruForm.gettelefon());
			statement.setString(5, basvuruForm.geteposta());
			statement.setDate(6, basvuruForm.getdtarih());
			statement.setBoolean(7, basvuruForm.getis_parakende());
			statement.setString(8, basvuruForm.gettercih_neden());
			statement.setString(9, basvuruForm.gettercih_il());
			statement.setString(10, basvuruForm.gettercih_ilce());
			statement.setString(11, basvuruForm.gettercih_semt());
			statement.setString(12, basvuruForm.getyatirim());
			statement.setString(13, basvuruForm.getekstra());
			statement.execute();
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			if(e.getErrorCode()==1062)
				bootstrapModal.setType(ModelType.Warning).setTitle("İlginize Teşekkür Ederiz").setBody("Daha önce başvuru formu göndermişsiniz");
			else
				bootstrapModal.setType(ModelType.Error).setTitle("SQL Hatası").setBody(e.getMessage()+"---"+e.getErrorCode());
		
			//connection init edilirken hidden fonksiyonu çağrılmış olabilir.
			throw bootstrapModal.show();
		}
		
	}
	
	
	
	
}
