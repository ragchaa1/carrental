package mum.edu.se.coursework.carrental.service;

import lombok.extern.java.Log;
import mum.edu.se.coursework.carrental.entity.Payment;
import mum.edu.se.coursework.carrental.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Log
public class StreamService {

    @Autowired
    UserService userService;

    public Function<List<User>, Map<String, Long>> getStateStat =
            (list) ->
                    list.stream().collect(Collectors.groupingBy(e -> e.getStateCode(), Collectors.counting()));

    public Function<List<Payment>, Map<Integer, Double>> getMonthStat =
            (list) ->
                    list.stream().collect(Collectors.groupingBy(e -> e.getDate().getMonthValue(), Collectors.summingDouble(t->t.getAmount())));

    //  Map<Integer, Double> collect = paymentList.stream().collect(Collectors.groupingBy(e -> e.getDate().getYear(), Collectors.summingDouble(t -> t.getAmount())));

    public Function<List<Payment>, Map<Integer, Double>> getYearStat =
            (list) ->
                    list.stream().collect(Collectors.groupingBy(e -> e.getDate().getYear(),Collectors.summingDouble(t -> t.getAmount())));


}
