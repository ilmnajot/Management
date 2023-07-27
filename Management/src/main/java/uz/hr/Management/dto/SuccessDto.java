package uz.hr.Management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SuccessDto {
    @Builder.Default
    private Boolean success=Boolean.TRUE;
    @Builder.Default
    private String status="OK";
}
