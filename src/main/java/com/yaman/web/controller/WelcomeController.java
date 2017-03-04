package com.yaman.web.controller;



import java.util.List;

import javax.validation.Valid;

/**
 * @author Arif
 *
 */


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yaman.web.connection.MyConnection;
import com.yaman.web.modal.BasvuruForm;
import com.yaman.web.modal.BootstrapModal;
import com.yaman.web.modal.BootstrapModal.ModelType;



@Controller
public class WelcomeController {

	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		
		try {
		new MyConnection();	//connection test edilir. Default olarak problemleri düzeltmeye çalışır. Veri tabanı ve tablo yoksa oluşturur.
		} catch (BootstrapModal e) {
			//hatalar varsa BootstrapModal içine map attribute olarak gömülmüştür. ve clienta gerekli attribute lar yollanır modal gösterilir.
			model.addAllAttributes(e.getAttributesMap());
		}
		
		return "welcome";
	}
	
	
	@RequestMapping(value="/add/basvuruform",method=RequestMethod.POST)
	public String addBasvuruForm(@Valid @ModelAttribute("basvuruform")  BasvuruForm basvuruForm, BindingResult bindingResult,ModelMap model) {
	
			//hatalı veya başarılı durum için bsmodal oluşturulur. 	
			BootstrapModal bsmodal=new BootstrapModal().setType(ModelType.Error).setTitle("Formu Kontrol Edin");
	
		
			//eğer girilen verilerde problemler varsa bsmodal içine gömülür
	        if (bindingResult.hasErrors()) { 
	          for (ObjectError objectError : bindingResult.getAllErrors()) {
	        	  
	        	  bsmodal.add_to_body("-"+objectError.getDefaultMessage());
	          }
	         
	        }else{
	        
	        	try {
	        		MyConnection myconection=new MyConnection();
	        		myconection.addBasvuruForm(basvuruForm);
		        	bsmodal.setType(ModelType.Success).setTitle("Başarılı").setBody("Formunuz bize Ulaştı Teşekkürler...");

				} catch (BootstrapModal e) {
					/*
					 * Eğer info türünden bir modal throw edildiyse 
					 * bu myconnection oluştulurken hataların düzeltilmiş olduğuna işarettir.
					 * addBasvuruForm medhodu çalışmamıştır. Kullanıcıya formun iletilmediği Warning türünden bir modal ile gösterilir.
					 * 
					 */
					if(e.geType()==ModelType.Info)
						e.add_to_body("-Formunuz gönderilemedi tekrar deneyin").setType(ModelType.Warning);
					
					/*
					 * Değilse problemler form veritabanına eklenirken oluşmuştur. Muhtemel SQL hataları döner bu da kullanıcıya gösterilir.
					 */
				
					model.addAllAttributes(e.getAttributesMap());
					return "returnbsmodal";
				}
	        	
	        	
	        		
	        }
	        
	        //hatalı veya başarılı durumlar bsmodal a gömülmüştür. Spring framework UI ModelPapine bsmodaldan gelen değerler attribute olarak gömülür.
	        model.addAllAttributes(bsmodal.getAttributesMap());
	        
	        //welcome.jsp üzerinden çağrıldığında 
	        return "returnbsmodal";
	    }

}
