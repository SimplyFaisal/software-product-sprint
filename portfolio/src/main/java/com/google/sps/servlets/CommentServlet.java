// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;


/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/comment")
public class CommentServelet extends HttpServlet {
	CommentService commentService = new CommentService(DatastoreServiceFactory.getDatastoreService());

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
  	Long id = Long.parseLong(request.getParameter("id"))
  	Comment comment = commentService.get(id);

  	response.setContentType("application/json;");
  	 // Serialize as JSON and return the response.
    response.getWriter().println(new Gson().toJson(comment));
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
  	Comment comment = new Comment()
  		.setText(request.getParameter("text"))
  		.setTimestamp(System.getCurrentTimeMillis());

    // Save the comment so it can be assigned an id.
    comment = commentService.create(comment);
    response.setContentType("application/json;");
    // Serialize as JSON and return the response.
    response.getWriter().println(new Gson().toJson(comment));
  }

  @Override
  public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
  	Comment comment = new Comment()
  		.setId(Long.parseLong(request.getParameter("id")))
  		.setText(request.getParameter("text"))
  		.setTimestamp(System.getCurrentTimeMillis());

    comment = commentService.update(comment);
    response.setContentType("application/json;");
    // Serialize as JSON and return the response.
    response.getWriter().println(new Gson().toJson(comment));
  }
}
