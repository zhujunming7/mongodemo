package com.dykj;

import com.mongodb.BasicDBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.UnknownHostException;

@Controller
public class DemoController {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    GridFsTemplate gridFsTemplate;
    @Autowired
    MongoDbFactory mongoDbFactory;
     @GetMapping(value = "/upload")
     public  void upload()
     {
         try {
             org.springframework.core.io.Resource resource = new FileSystemResource("C:\\Users\\liukun\\Desktop\\timg.jfif");
             ObjectId id = gridFsTemplate.store(resource.getInputStream(), resource.getFilename(), ".jfif");
             System.out.println("_id:"+id);
         }catch (Exception e)
         {
             e.printStackTrace();
         }



     }



}
