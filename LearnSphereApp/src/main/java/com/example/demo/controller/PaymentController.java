package com.example.demo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Course;
import com.example.demo.services.CourseService;
import com.example.demo.services.UsersService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {
    @Autowired
    CourseService cserv;

    @Autowired
    UsersService userv;

    @PostMapping("/createorder")
    @ResponseBody
    public String createOrder(@RequestParam(required = false) Integer courseId, @RequestParam(required = false) Integer coursePrice) {
        if (courseId == null || coursePrice == null) {
            return "Error: courseId or coursePrice is missing";
        }

        Order order = null;
        try {
            RazorpayClient razorpay = new RazorpayClient("rzp_test_9jELWCaa4Mf7sv", "fLAe2qiP5PND6nyzx1ANAI2s");

            JSONObject orderRequest = new JSONObject();
            // Convert course price to paisa (1 INR = 100 paisa)
            int amountInPaisa = coursePrice * 100;
            orderRequest.put("amount", amountInPaisa);
            orderRequest.put("currency", "INR");
            orderRequest.put("receipt", "receipt#" + courseId);

            order = razorpay.orders.create(orderRequest);

        } catch (Exception e) {
            System.out.println("Exception while creating order.");
            e.printStackTrace();
        }

        return order != null ? order.toString() : "{}";
    }

    @PostMapping("/verify")
    @ResponseBody
    public boolean verifyPayment(@RequestParam String orderId, @RequestParam String paymentId, @RequestParam String signature) {
        try {
            // Initialize Razorpay client with your API key and secret
            RazorpayClient razorpayClient = new RazorpayClient("rzp_test_9jELWCaa4Mf7sv", "fLAe2qiP5PND6nyzx1ANAI2s");
            // Create a signature verification data string
            String verificationData = orderId + "|" + paymentId;

            // Use Razorpay's utility function to verify the signature
            boolean isValidSignature = Utils.verifySignature(verificationData, signature, "fLAe2qiP5PND6nyzx1ANAI2s");

            return isValidSignature;
        } catch (RazorpayException e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/payment-success")
    public String paymentSuccess(HttpSession session, @RequestParam int courseId) {
        String email = (String) session.getAttribute("email");
        Course course = cserv.findCourseById(courseId);
        userv.addCourseToUser(email, course);
        return "customerhome";

    }

    @GetMapping("/payment-failure")
    public String paymentFailure() {
        return "customerhome";
    }
}
