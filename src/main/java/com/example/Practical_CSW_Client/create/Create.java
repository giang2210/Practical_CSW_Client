package com.example.Practical_CSW_Client.create;

import com.example.Practical_CSW_Client.Product;
import com.example.Practical_CSW_Client.ProductService;
import com.example.Practical_CSW_Client.RetrofitServiceGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Create extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Create.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Name = req.getParameter("Name");
        double Price = Double.parseDouble(req.getParameter("Price"));
        int Quantity = Integer.parseInt(req.getParameter("Quantity"));
        ProductService productService = RetrofitServiceGenerator.createService(ProductService.class);
        productService.add(new Product(Name,Price,Quantity)).execute();
        resp.sendRedirect("/Liste");

    }
}
