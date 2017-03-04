package com.yaman.web.modal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arif
 *
 */

//Kullanıcıyı bilgilendirmek amacıyla DOM için bir bootstrap modal objesi throw eder.
public  class BootstrapModal extends Throwable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private	String title;
	private	String body;
	private ModelType modalType;
	private boolean show;
	
	
	
	public BootstrapModal() {
		setTitle("");
		setBody("");
		setType(ModelType.Error);
		show=true;
		
	}
	
	public BootstrapModal setBody(String body) {
		this.body=body;
		return this;
	}
	
	public BootstrapModal hidden() {
		this.show=false;
		return this;
	}
	
	public BootstrapModal setTitle(String title) {
		this.title=title;
		return this;
	}
	
	
	//classlarına göre tipleri belirlenir.
	public BootstrapModal setType(ModelType type) {
		this.modalType=type;
		
	return this;
	}
	public ModelType geType() {
		return modalType;
	}
	
	
	public Map<String, String> getAttributesMap() {
		Map<String, String> map=new HashMap<String,String>();
		map.put("modal_title", title);
		map.put("modal_body", body);
		map.put("modal_type", modalType.value);
		if(show)
		map.put("modal_show", "1");
		return map;
		
		
	}
	
	//var olan objenin body kısmına metin eklenmesi olayı
	public BootstrapModal add_to_body(String str){
	      body+="<br>"+str;
	      return this;
	}
	
	
	public BootstrapModal show() {
		show=true;
		return this;
	}

	
	
	
//burada enum kullanmamın nedeni daha sonraları EVET-HAYIR lı bir bootstrap modal tasarlanırsa kullanılması için.
	public enum ModelType {
		 Success("success"), Info("info"), Warning("warning"),Error("danger");
		
	
		private final String value;

		//Şimdilik sadece bootstrap modal objesinin body classı için kullanılmaktadır.
		private ModelType(String value) {
	        this.value = "alert alert-"+value;
	    }
		
	}
	
}
