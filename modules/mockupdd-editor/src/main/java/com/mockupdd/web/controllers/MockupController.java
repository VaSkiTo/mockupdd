package com.mockupdd.web.controllers;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mockupdd.model.Mockup;
import com.mockupdd.services.MockupService;

@Controller
public class MockupController extends BaseController {

  @Autowired
  private MockupService mockupService;

  @RequestMapping("/projects/{projectId}/mockups/{mockupId}/")
  public ModelAndView viewMockup(@PathVariable("projectId") Long projectId, @PathVariable("mockupId") Long mockupId) {
    ModelAndView mv = this.getView("mockup-view");
    mv.addObject("mockup", this.mockupService.getMockup(mockupId));
    return mv;
  }

  @RequestMapping(value = "/projects/{projectId}/mockups/", method = RequestMethod.POST)
  public ModelAndView createMockup(@PathVariable("projectId") Long projectId, @FormParam("name") String name, @RequestParam("image") MultipartFile image) {
    try {
      Mockup mockup = this.mockupService.createMockup(projectId, name, image);
      return new ModelAndView("redirect:/projects/" + projectId + "/mockups/" + mockup.getId() + "/");
    } catch (IOException e) {
      return null;
    }
  }
}
