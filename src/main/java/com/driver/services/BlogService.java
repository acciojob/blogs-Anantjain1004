//package com.driver.services;
//
//import com.driver.models.Blog;
//import com.driver.models.Image;
//import com.driver.models.User;
//import com.driver.repositories.BlogRepository;
//import com.driver.repositories.ImageRepository;
//import com.driver.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
////import java.util.ArrayList;
////import java.util.Date;
//import java.util.List;
//
//@Service
//public class BlogService {
//    @Autowired
//    BlogRepository blogRepository1;
//
//    @Autowired
//    UserRepository userRepository1;
//
//    @Autowired
//    ImageRepository imageRepository;
//
//    public Blog createAndReturnBlog(Integer userId, String title, String content) {
//        //create a blog at the current time
//        User user = userRepository1.findById(userId).get();
//        Blog blog = new Blog();
//        blog.setTitle(title);
//        blog.setContent(content);
//        blog.setUser(user);
//
//
//        //adding blogs to the user
////        List<Blog> blogList = user.getBlogsMade();
////        blogList.add(blog);
//        user.getBlogsMade().add(blog);
//        userRepository1.save(user);
//        return blog;
//    }
//
//    public void deleteBlog(int blogId){
//        //delete blog and corresponding images
//        Blog blog = blogRepository1.findById(blogId).get();
//        List<Image> imagesOfBlog = blog.getImagesList();
//        for(Image i:imagesOfBlog){
//            imagesOfBlog.remove(i);
//            imageRepository.delete(i);
//        }
//
//        blogRepository1.deleteById(blogId);
//    }
//}

package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time

//        if(!userRepository1.findById(userId).isPresent()){
//            throw new Exception();
//        }
        User user = userRepository1.findById(userId).get();
        Blog blog = new Blog(user,title,content);
        userRepository1.save(user); //Blog saved in repo by cascading
        user.getBlogList().add(blog);
        return blog;

    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        blogRepository1.deleteById(blogId);
    }
}

//package com.driver.services;
//
//import com.driver.models.Blog;
//import com.driver.models.Image;
//import com.driver.models.User;
//import com.driver.repositories.BlogRepository;
//import com.driver.repositories.ImageRepository;
//import com.driver.repositories.UserRepository;
//import com.sun.istack.NotNull;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class BlogService {
//    @Autowired
//    BlogRepository blogRepository1;
//
//    @Autowired
//    UserRepository userRepository1;
//
//    public Blog createAndReturnBlog(Integer userId, String title, String content) throws Exception {
//        //create a blog at the current time
//
//        if(!userRepository1.findById(userId).isPresent()){
//            throw new Exception();
//        }
//        User user = userRepository1.findById(userId).get();
//        Blog blog = new Blog(user,title,content);
//        userRepository1.save(user); //Blog saved in repo by cascading
//        user.getBlogList().add(blog);
//        return blog;
//
//    }
//
//    public void deleteBlog(int blogId){
//        //delete blog and corresponding images
//        blogRepository1.deleteById(blogId);
//    }
//}