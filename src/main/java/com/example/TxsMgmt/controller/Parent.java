package com.example.TxsMgmt.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

public class Parent extends OncePerRequestFilter {



    public static void main(String[] args) {
        Integer x = 100;
        Integer y = 100;

        if (x == y) {
            System.out.println("Same object");
        } else {
            System.out.println("Different object");
        }

        Integer a = 200;
        Integer b = 200;

        if (a.equals(b)) {
            System.out.println("Same object");
        } else {
            System.out.println("Different object");
        }


    }
        @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    }
}
