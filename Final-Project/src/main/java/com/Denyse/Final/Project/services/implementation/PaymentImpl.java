package com.Denyse.Final.Project.services.implementation;

import com.Denyse.Final.Project.repository.PaymentRepo;
import com.Denyse.Final.Project.model.CustomerOrder;
import com.Denyse.Final.Project.model.Payment;
import com.Denyse.Final.Project.services.CustomerOrderService;
import com.Denyse.Final.Project.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentImpl implements PaymentService {
    @Autowired
    private PaymentRepo repo;
    @Autowired
    private CustomerOrderService customerOrderService;

    @Override
    public List<Payment> getAllPayments() {
        return repo.findAll();
    }

    @Override
    public void savePayment(Payment payment, Model model) {
        payment.setStatus(true);
        CustomerOrder customerOrder = payment.getCustomerOrder();

        customerOrder.setPaid(true);
        //customerOrderService.saveCustomerOrder(customerOrder,model);

        repo.save(payment);
    }

    @Override
    public void updatePayment(Payment payment) {
        repo.save(payment);
    }

    @Override
    public Optional<Payment> findByID(UUID id) {
        return repo.findById(id);
    }

    @Override
    public void deleteById(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public long countPayments() {
        return repo.count();
    }


}
