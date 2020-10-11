package kjc;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import kjc.service.KjcVO;
import kjc.service.mapper.kjcMapper;
 
@Controller
public class SampleController {
    
//    @Autowired
//    private kjcMapper mapper;
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home(Model model) throws Exception{
        model.addAttribute("name", "김재창");
        
        
        return "main";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() throws Exception {
//    		List<KjcVO> list = mapper.selectkjcList();
//        
//        for(int i=0; i<list.size(); i++){
//            System.out.println("id : " + list.get(i).getKid());        
//            System.out.println("name : " + list.get(i).getKname());
//            System.out.println("address : " + list.get(i).getKaddress());
//            System.out.println("phone : " + list.get(i).getKphone());
//        }        
    	return "login";
    	
    }
 
}
