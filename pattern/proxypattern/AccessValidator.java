package proxypattern;

/**
 * Created by zfz on 2017/12/11.
 */
public class AccessValidator {

    public boolean validate(String userID){
        System.out.println("在数据库查询 "+userID+" 是否存在");
        if(userID.equalsIgnoreCase("李四")){
            System.out.println("用户 "+userID+" 登录成功 ");
            return true;
        }
        return false;
    }

}
