package kjc;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kjc.service.KjcVO;
import kjc.service.mapper.kjcMapper;
 
@Controller
@EnableAutoConfiguration
public class SampleController {
    
    @Autowired
    private kjcMapper mapper;
    
    @RequestMapping(value="/")
    @ResponseBody
    public String home() throws Exception{
        
        List<KjcVO> list = mapper.selectkjcList();
        
        for(int i=0; i<list.size(); i++){
            System.out.println("team : " + list.get(i).getKid());        
            System.out.println("team : " + list.get(i).getKname());
            System.out.println("name : " + list.get(i).getKaddress());
            System.out.println("team : " + list.get(i).getKphone());
        }        
        
        return "hello Gradle!";
    }
 
}
