package com.example.javaspringassignment.seed;

import com.example.javaspringassignment.entity.District;
import com.example.javaspringassignment.entity.Street;
import com.example.javaspringassignment.repository.DistrictRepository;
import com.example.javaspringassignment.repository.StreetRepository;
import com.example.javaspringassignment.util.StreetStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class loadData implements CommandLineRunner {
    @Autowired
    StreetRepository streetRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public void run(String... args) throws Exception {
        loadDistrict();
        loadStreet();
    }
    private void loadDistrict(){
        if (districtRepository.count() == 0){
            District district1 = District.builder().name("Ba Dinh").build();
            District district2 = District.builder().name("Thanh Xuan").build();
            District district3 = District.builder().name("Hoàn Kiếm").build();
            District district4 = District.builder().name("Tây Hồ").build();
            District district5 = District.builder().name("Cầu Giây").build();
            districtRepository.save(district1);
            districtRepository.save(district2);
            districtRepository.save(district3);
            districtRepository.save(district4);
            districtRepository.save(district5);
        }
        System.out.println(districtRepository.count());
    }
    private void loadStreet(){
        if (streetRepository.count() == 0){
            Street street1 = Street.builder()
                    .name("Tân Ấp").description("Tân ấp").status(StreetStatus.USING).district_id(1)
                    .build();
            Street street2 = Street.builder()
                    .name("An Dương").description("An Dương").status(StreetStatus.UNDER_CONSTRUCTION).district_id(1)
                    .build();
            Street street3 = Street.builder()
                    .name("Vương Thừa Vũ").description("Vương Thừa Vũ").status(StreetStatus.FIX).district_id(2)
                    .build();
            Street street4 = Street.builder()
                    .name("Hồ Rùa").description("Hồ Rùa").status(StreetStatus.USING).district_id(2)
                    .build();
            Street street5 = Street.builder()
                    .name("Hàng Buồm").description("Hàng Buồm").status(StreetStatus.UNDER_CONSTRUCTION).district_id(3)
                    .build();
            Street street6 = Street.builder()
                    .name("Tạ Hiện").description("Tạ Hiện").status(StreetStatus.FIX).district_id(3)
                    .build();
            Street street7 = Street.builder()
                    .name("Hàn Quốc").description("Hàn Quốc").status(StreetStatus.USING).district_id(4)
                    .build();
            Street street8 = Street.builder()
                    .name("Nhật Bản").description("Nhật Bản").status(StreetStatus.USING).district_id(4)
                    .build();
            Street street9 = Street.builder()
                    .name("Duy Tân").description("Duy Tân").status(StreetStatus.USING).district_id(5)
                    .build();
            Street street10 = Street.builder()
                    .name("Trần Bình").description("Trần Bình").status(StreetStatus.USING).district_id(5)
                    .build();
            streetRepository.save(street1);
            streetRepository.save(street2);
            streetRepository.save(street3);
            streetRepository.save(street4);
            streetRepository.save(street5);
            streetRepository.save(street6);
            streetRepository.save(street7);
            streetRepository.save(street8);
            streetRepository.save(street9);
            streetRepository.save(street10);
        }
        System.out.println(streetRepository.count());
    }
}
