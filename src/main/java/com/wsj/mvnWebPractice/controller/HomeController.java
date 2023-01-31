package com.wsj.mvnWebPractice.controller;

import com.wsj.mvnWebPractice.entity.DiscussPost;
import com.wsj.mvnWebPractice.entity.Page;
import com.wsj.mvnWebPractice.entity.User;
import com.wsj.mvnWebPractice.service.DiscussPostService;
import com.wsj.mvnWebPractice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page ) {
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");
        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost post : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }
        }
//        User me = hostHolder.getUser();
//        int letterUnreadCount = me==null? 0 : messageService.findLetterUnreadCount(me.getId(), null);
        model.addAttribute("discussPosts", discussPosts);
//        model.addAttribute("letterUnreadCount", letterUnreadCount);
        return "/index";
    }
}
