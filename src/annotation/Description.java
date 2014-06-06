package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @Target：表示该注释用在的地方
 * 			
 * 			ElemenetType.CONSTRUCTOR 构造器声明
 * 			ElemenetType.FIELD 域声明（包括 enum 实例）
 * 			ElemenetType.LOCAL_VARIABLE 局部变量声明
 * 			ElemenetType.METHOD 方法声明
 * 			ElemenetType.PACKAGE 包声明	
 * 			ElemenetType.PARAMETER 参数声明
 * 			ElemenetType.TYPE 类，接口（包括注解类型）或enum声明
 * 
 * @author lijian
 *
 */


@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Description {

	public String author();

    public int age();
    
    public String sex() default "男";

}

/**
 * 
 * 5.20:6：30
 *
 * 11 ： 00 --->6:00
 * 
 * 6:00   --->7:00
 */
