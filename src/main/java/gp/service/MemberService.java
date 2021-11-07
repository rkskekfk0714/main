package gp.service;



import gp.domain.Cart;
import gp.domain.Member;
import gp.domain.MemberRepository;
import gp.web.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor

public class MemberService {

    private final MemberRepository memberRepository;


    // 회원가입
    public Long joinUser(MemberDto memberDto) {
        return memberRepository.save(memberDto.toEntity()).getId();
    }

    /*
    // 중복 아이디 체크
    public int userIdCheck(String username) {

        memberRepository = memberRepository.idcheck(MemberDto.class);

        return userDao.checkOverId(user_id);
    }

     */


    // 로그인


    public MemberDto userLogin(MemberDto memberDto){

        List<Member> memberList = memberRepository.findAll();

        for( Member temp : memberList){
            if(temp.getUsername().equals(memberDto.getUsername()) && temp.getPassword().equals(memberDto.getPassword())){
                MemberDto dto = new MemberDto();
                dto.setId(temp.getId());
                dto.setUsername(temp.getUsername());
                dto.setPassword(temp.getPassword());
                dto.setName(temp.getName());
                dto.setEmail(temp.getEmail());

                return dto;
            }
        }
        return null;
    }

    @Transactional
    public List<MemberDto> getMemberList(){

        List<Member> memberList = memberRepository.findAll();
        List<MemberDto> memberDtoList=new ArrayList<>();

        for( Member member   : memberList){
            MemberDto memberDto = MemberDto.builder()
                    .id(member.getId())
                    .address(member.getAddress())
                    .date(member.getDate())
                    .gender(member.getGender())
                    .name(member.getName())
                    .password(member.getPassword())
                    .email(member.getEmail())
                    .username(member.getUsername())
                    .phone(member.getPhone())
                    .build();

            memberDtoList.add(memberDto);

        }
        return memberDtoList;
    }


    @Transactional
    public MemberDto getMember(Long id){
        Optional<Member> memberEntityWrapper = memberRepository.findById(id);
        Member member= memberEntityWrapper.get();

        MemberDto memberDto = MemberDto.builder()
                .id(member.getId())
                .address(member.getAddress())
                .date(member.getDate())
                .gender(member.getGender())
                .name(member.getName())
                .password(member.getPassword())
                .email(member.getEmail())
                .username(member.getUsername())
                .phone(member.getPhone())
                .build();

        return memberDto;

    }

    public Long saveMember(MemberDto memberDto){
        return memberRepository.save(memberDto.toEntity()).getId();
    }


    @Transactional
    public void memberDelete(Long id){
        Optional<Member> optionalMember = memberRepository.findById(id);
        Member member=optionalMember.get();

        memberRepository.delete(member);
    }

    @Transactional
    public void userUpdatePwd(Long id, String password) {

        memberRepository.updatePwd(id, password);
    }

    @Transactional
    public void deleteUser(Long id) {

        memberRepository.deleteById(id);
    }



    //---------------------------------------------------------


    // 아이디 찾기
    public MemberDto findid(MemberDto memberDto){

        List<Member> memberList = memberRepository.findAll();

        for( Member temp : memberList){
            if(temp.getName().equals(memberDto.getName()) && temp.getEmail().equals(memberDto.getEmail())){
                MemberDto dto = new MemberDto();
                dto.setId(temp.getId());
                dto.setUsername(temp.getUsername());
                dto.setPassword(temp.getPassword());
                dto.setName(temp.getName());
                dto.setEmail(temp.getEmail());

                return dto;
            }
        }
        return null;
    }


    // 비밀번호 찾기
    public MemberDto findpwd(MemberDto memberDto){

        List<Member> memberList = memberRepository.findAll();

        for( Member temp : memberList){
            if(temp.getUsername().equals(memberDto.getUsername()) && temp.getName().equals(memberDto.getName()) && temp.getEmail().equals(memberDto.getEmail())){
                MemberDto dto = new MemberDto();
                dto.setId(temp.getId());
                dto.setUsername(temp.getUsername());
                dto.setPassword(temp.getPassword());
                dto.setName(temp.getName());
                dto.setEmail(temp.getEmail());

                return dto;
            }
        }
        return null;
    }

    @Transactional
    public void pwdchange(Long id, String password) {

        memberRepository.updatePwd(id, password);
    }


}


