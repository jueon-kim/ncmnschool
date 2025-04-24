package com.ncmn.school.web;

import com.ncmn.school.member.Member;
import com.ncmn.school.member.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 관리자 컨트롤러
    @PostMapping("/admin/members")
    public String create(Member member) {
        System.out.println("회원 가입 요청: " + member.getName()); // 디버깅용 로그
        memberService.join(member);
        return "redirect:/home"; // 가입 후 메인으로 리다이렉트
    }

    @GetMapping(value = "/admin/members")
    public String list(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "/admin/members"; // members.html 렌더링
    }

    // 회원 등록 컨트롤러
    @GetMapping(value = "/home")
    public String home(@RequestParam(name="home", required = false, defaultValue = "home") String home, Model model){
        model.addAttribute("home", home);
        return "/home";
    }

    @GetMapping("/member/join")
    public String joinForm(){
        return "member/join";

    }

}
