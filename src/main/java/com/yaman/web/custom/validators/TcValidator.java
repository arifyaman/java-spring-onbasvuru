/**
 * 
 */
package com.yaman.web.custom.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import com.yaman.web.custom.IsValidTc;



/**
 * @author Arif
 *
 */
public class TcValidator implements ConstraintValidator<IsValidTc, String> {

	@Override
	public void initialize(IsValidTc arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		
		return is_valid_tc(arg0);
	}
	
	boolean is_valid_tc(String tc){
		try {

		char[] cs=tc.toCharArray();
		
		//11 karakterli değilse doğru döner çünkü error zaten alınmıştır.
		if(cs.length!=11)return true;
		
		int temp=0;
		int temp2=0;
		
		//1,3,5,7,9 hanelerinin toplamının 7 katından 2,4,6,8 hanelerin toplamı çıkarılırsa sonucun mod 10 u 10. haneyi 
		//ve 1,2,3,4,5,6,7,8,9,10 hanelerinin toplamının mod 10 u da 11. haneyi vermeli
		for (int i = 0; i < cs.length; i++) {
			if(i<9)
				if(i%2==0)	
					temp+= Character.getNumericValue(cs[i])*7; //matematik dağılma kuralı ^^
				else
					temp-=Character.getNumericValue(cs[i]);
			
			if(i<10)
				temp2+=Character.getNumericValue(cs[i]);
				
				
		}
	
		
			return (temp%10==Character.getNumericValue(cs[9])&&temp2%10==Character.getNumericValue(cs[10]));

		} catch (Exception e) {
			/*
			 *Buraya düşüyorsa tc sayılardan oluşmadığı için düşüyordur 
			 * doğru döner çünkü error zaten handle edilmiştir.Değer 11 karakterli ve sayı ise doğruluğunun kontrol edilmesini istiyorum
			 */
			return true; 
		}
		
	
		
	}

}
