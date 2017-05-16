
import com.era.dao.UserDao;
import com.era.dao.UserDaoImpl;
import com.era.model.Company;
import com.era.model.Equipment;
import com.era.model.Specification;
import com.era.model.User;
import com.era.util.DBUtil;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LQwabe
 */
public class Test {

    public static void main(String[] args) throws Exception {

        Equipment equipment = DBUtil.getEquipmentById(4);
        Specification specification = equipment.getSpecification();
        String picture_filetype = specification.getPictureFiletype();
        Company company = equipment.getManufacturer();
        System.out.println(picture_filetype);
        System.out.println(equipment.getName());
    }

}
