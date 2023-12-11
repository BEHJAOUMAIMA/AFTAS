package com.example.aftas.dto.response;

import com.example.aftas.domain.Member;
import com.example.aftas.dto.request.MemberRequestDTO;
import com.example.aftas.enums.IdentityDocumentType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public record MemberResponseDTO(
        Long id,
        String name,
        String familyName,
        LocalDateTime accessionDate,
        String nationality,
        IdentityDocumentType identityDocumentType,
        String identityNumber

        ) {

        public static MemberResponseDTO fromMember(Member member) {
                return new MemberResponseDTO(
                        member.getId(),
                        member.getName(),
                        member.getFamilyName(),
                        member.getAccessionDate(),
                        member.getNationality(),
                        member.getIdentityDocumentType(),
                        member.getIdentityNumber()
                );
        }

}
