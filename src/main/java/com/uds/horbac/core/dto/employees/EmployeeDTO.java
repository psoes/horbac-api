package com.uds.horbac.core.dto.employees;
import java.util.List;

import com.uds.horbac.core.dto.emp_educationInfo.AwardDTO;
import com.uds.horbac.core.dto.emp_educationInfo.SchoolDTO;
import com.uds.horbac.core.dto.emp_famillyInfo.PartenaireConjugalDTO;
import com.uds.horbac.core.dto.emp_healthInfo.HospitalDTO;
import com.uds.horbac.core.dto.emp_healthInfo.PharmacyDTO;
import com.uds.horbac.core.dto.emp_justiceInfo.LitigationJusticeDTO;
import com.uds.horbac.core.dto.emp_ownershipInfo.BankAccountDTO;
import com.uds.horbac.core.dto.emp_ownershipInfo.BiensImmobiliersDTO;
import com.uds.horbac.core.dto.emp_ownershipInfo.DeviceDTO;
import com.uds.horbac.core.dto.emp_ownershipInfo.VehicleDTO;
import com.uds.horbac.core.dto.emp_passionInfo.HairdressingSalonDTO;
import com.uds.horbac.core.dto.emp_passionInfo.HobbyDTO;
import com.uds.horbac.core.dto.emp_passionInfo.RestaurantDTO;
import com.uds.horbac.core.dto.emp_passionInfo.SewingSalonDTO;
import com.uds.horbac.core.dto.emp_passionInfo.VisitDTO;
import com.uds.horbac.core.dto.emp_personalInfo.BiometricCaracteristicsDTO;
import com.uds.horbac.core.dto.emp_personalInfo.HandicapDTO;
import com.uds.horbac.core.dto.emp_personalInfo.PersonDTO;
import com.uds.horbac.core.dto.emp_personalInfo.ReligionDTO;
import com.uds.horbac.core.dto.emp_personalInfo.SpecialIdentityDTO;
import com.uds.horbac.core.dto.emp_workInfo.OccupiedFunctionDTO;
import com.uds.horbac.core.entities.emp_famillyInfo.MaritalStatus;
import com.uds.horbac.core.entities.emp_personalInfo.Regime;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class EmployeeDTO extends PersonDTO

{
   
    private List<SewingSalonDTO> sewingSalons;
    
    private List<HairdressingSalonDTO> hairdressingSalons;

  
    private List<RestaurantDTO> restaurants;
   
   
    private List<HobbyDTO> hobbies;
   
    private List<BiensImmobiliersDTO> biensImmobiliers;
  
    private List<VehicleDTO> vehicules;
  
    private List<BankAccountDTO> bankAccounts;
   
    private List<AwardDTO> awards;
    
    private List<VisitDTO> visits;
   
    private List<SchoolDTO> schools;
   
    private SpecialIdentityDTO specialID;
   
    private List<PharmacyDTO> pharmacies;

    private List<OccupiedFunctionDTO> occupiedFunctions;

    private List<DeviceDTO> devices;

    private List<LitigationJusticeDTO> litigationJustices;    
   
    private List<HospitalDTO> hospitals;
    
    private MaritalStatus maritalStatus;
    
    private boolean tagniOrMagni;
  
    private List<PersonDTO> children;
  
    private List<PersonDTO> brotherSisters;
   
    private List<PersonDTO> tutors;
    
    private List<PersonDTO> friends;
 
    private List<PartenaireConjugalDTO> partnerships;
   
    private List<HandicapDTO> handicaps;
  
    private ReligionDTO religion;
  
    private BiometricCaracteristicsDTO biometricCaracteristics;
    
    private Regime regime;
}

