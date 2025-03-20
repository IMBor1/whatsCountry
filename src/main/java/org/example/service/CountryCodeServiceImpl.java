package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.exception.CountryNotFoundException;
import org.example.model.CountryCode;
import org.example.repository.CountryCodeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CountryCodeServiceImpl implements CountryCodeService {
    private final CountryCodeRepository repository;

    @PostConstruct
    public void loadCountryCodes() {
        log.info("Начало загрузки кодов стран");
        String[][] countries = {
            {"Afghanistan", "+93"},
            {"Åland Islands", "+358"},
            {"Albania", "+355"},
            {"Algeria", "+213"},
            {"American Samoa", "+1-684"},
            {"Andorra", "+376"},
            {"Angola", "+244"},
            {"Anguilla", "+1-264"},
            {"Antarctica", "+672"},
            {"Antigua and Barbuda", "+1-268"},
            {"Argentina", "+54"},
            {"Armenia", "+374"},
            {"Aruba", "+297"},
            {"Australia", "+61"},
            {"Austria", "+43"},
            {"Azerbaijan", "+994"},
            {"Bahamas", "+1-242"},
            {"Bahrain", "+973"},
            {"Bangladesh", "+880"},
            {"Barbados", "+1-246"},
            {"Belarus", "+375"},
            {"Belgium", "+32"},
            {"Belize", "+501"},
            {"Benin", "+229"},
            {"Bermuda", "+1-441"},
            {"Bhutan", "+975"},
            {"Bolivia", "+591"},
            {"Bonaire", "+599"},
            {"Bosnia and Herzegovina", "+387"},
            {"Botswana", "+267"},
            {"Bouvet Island", "+47"},
            {"Brazil", "+55"},
            {"British Indian Ocean Territory", "+246"},
            {"Brunei", "+673"},
            {"Bulgaria", "+359"},
            {"Burkina Faso", "+226"},
            {"Burundi", "+257"},
            {"Cambodia", "+855"},
            {"Cameroon", "+237"},
            {"Canada", "+1"},
            {"Cape Verde", "+238"},
            {"Cayman Islands", "+1-345"},
            {"Central African Republic", "+236"},
            {"Chad", "+235"},
            {"Chile", "+56"},
            {"China", "+86"},
            {"Christmas Island", "+61"},
            {"Cocos Islands", "+61"},
            {"Colombia", "+57"},
            {"Comoros", "+269"},
            {"Congo", "+242"},
            {"Democratic Republic of Congo", "+243"},
            {"Cook Islands", "+682"},
            {"Costa Rica", "+506"},
            {"Côte d'Ivoire", "+225"},
            {"Croatia", "+385"},
            {"Cuba", "+53"},
            {"Curaçao", "+599"},
            {"Cyprus", "+357"},
            {"Czech Republic", "+420"},
            {"Denmark", "+45"},
            {"Djibouti", "+253"},
            {"Dominica", "+1-767"},
            {"Dominican Republic", "+1-809"},
            {"Ecuador", "+593"},
            {"Egypt", "+20"},
            {"El Salvador", "+503"},
            {"Equatorial Guinea", "+240"},
            {"Eritrea", "+291"},
            {"Estonia", "+372"},
            {"Ethiopia", "+251"},
            {"Falkland Islands", "+500"},
            {"Faroe Islands", "+298"},
            {"Fiji", "+679"},
            {"Finland", "+358"},
            {"France", "+33"},
            {"French Guiana", "+594"},
            {"French Polynesia", "+689"},
            {"French Southern Territories", "+262"},
            {"Gabon", "+241"},
            {"Gambia", "+220"},
            {"Georgia", "+995"},
            {"Germany", "+49"},
            {"Ghana", "+233"},
            {"Gibraltar", "+350"},
            {"Greece", "+30"},
            {"Greenland", "+299"},
            {"Grenada", "+1-473"},
            {"Guadeloupe", "+590"},
            {"Guam", "+1-671"},
            {"Guatemala", "+502"},
            {"Guernsey", "+44-14"},
            {"Guinea", "+224"},
            {"Guinea-Bissau", "+245"},
            {"Guyana", "+592"},
            {"Haiti", "+509"},
            {"Heard Island", "+672"},
            {"Vatican City", "+379"},
            {"Honduras", "+504"},
            {"Hong Kong", "+852"},
            {"Hungary", "+36"},
            {"Iceland", "+354"},
            {"India", "+91"},
            {"Indonesia", "+62"},
            {"Iran", "+98"},
            {"Iraq", "+964"},
            {"Ireland", "+353"},
            {"Isle of Man", "+44-16"},
            {"Israel", "+972"},
            {"Italy", "+39"},
            {"Jamaica", "+1-876"},
            {"Japan", "+81"},
            {"Jersey", "+44-15"},
            {"Jordan", "+962"},
            {"Kazakhstan", "+7"},
            {"Kenya", "+254"},
            {"Kiribati", "+686"},
            {"North Korea", "+850"},
            {"South Korea", "+82"},
            {"Kuwait", "+965"},
            {"Kyrgyzstan", "+996"},
            {"Laos", "+856"},
            {"Latvia", "+371"},
            {"Lebanon", "+961"},
            {"Lesotho", "+266"},
            {"Liberia", "+231"},
            {"Libya", "+218"},
            {"Liechtenstein", "+423"},
            {"Lithuania", "+370"},
            {"Luxembourg", "+352"},
            {"Macao", "+853"},
            {"Macedonia", "+389"},
            {"Madagascar", "+261"},
            {"Malawi", "+265"},
            {"Malaysia", "+60"},
            {"Maldives", "+960"},
            {"Mali", "+223"},
            {"Malta", "+356"},
            {"Marshall Islands", "+692"},
            {"Martinique", "+596"},
            {"Mauritania", "+222"},
            {"Mauritius", "+230"},
            {"Mayotte", "+262"},
            {"Mexico", "+52"},
            {"Micronesia", "+691"},
            {"Moldova", "+373"},
            {"Monaco", "+377"},
            {"Mongolia", "+976"},
            {"Montenegro", "+382"},
            {"Montserrat", "+1-664"},
            {"Morocco", "+212"},
            {"Mozambique", "+258"},
            {"Myanmar", "+95"},
            {"Namibia", "+264"},
            {"Nauru", "+674"},
            {"Nepal", "+977"},
            {"Netherlands", "+31"},
            {"New Caledonia", "+687"},
            {"New Zealand", "+64"},
            {"Nicaragua", "+505"},
            {"Niger", "+227"},
            {"Nigeria", "+234"},
            {"Niue", "+683"},
            {"Norfolk Island", "+672"},
            {"Northern Mariana Islands", "+1-670"},
            {"Norway", "+47"},
            {"Oman", "+968"},
            {"Pakistan", "+92"},
            {"Palau", "+680"},
            {"Palestine", "+970"},
            {"Panama", "+507"},
            {"Papua New Guinea", "+675"},
            {"Paraguay", "+595"},
            {"Peru", "+51"},
            {"Philippines", "+63"},
            {"Pitcairn", "+64"},
            {"Poland", "+48"},
            {"Portugal", "+351"},
            {"Puerto Rico", "+1-787"},
            {"Qatar", "+974"},
            {"Réunion", "+262"},
            {"Romania", "+40"},
            {"Russia", "+7"},
            {"Rwanda", "+250"},
            {"Saint Barthélemy", "+590"},
            {"Saint Helena", "+290"},
            {"Saint Kitts and Nevis", "+1-869"},
            {"Saint Lucia", "+1-758"},
            {"Saint Martin", "+590"},
            {"Saint Pierre and Miquelon", "+508"},
            {"Saint Vincent and the Grenadines", "+1-784"},
            {"Samoa", "+685"},
            {"San Marino", "+378"},
            {"Sao Tome and Principe", "+239"},
            {"Saudi Arabia", "+966"},
            {"Senegal", "+221"},
            {"Serbia", "+381"},
            {"Seychelles", "+248"},
            {"Sierra Leone", "+232"},
            {"Singapore", "+65"},
            {"Sint Maarten", "+1-721"},
            {"Slovakia", "+421"},
            {"Slovenia", "+386"},
            {"Solomon Islands", "+677"},
            {"Somalia", "+252"},
            {"South Africa", "+27"},
            {"South Georgia", "+500"},
            {"South Sudan", "+211"},
            {"Spain", "+34"},
            {"Sri Lanka", "+94"},
            {"Sudan", "+249"},
            {"Suriname", "+597"},
            {"Svalbard", "+47"},
            {"Swaziland", "+268"},
            {"Sweden", "+46"},
            {"Switzerland", "+41"},
            {"Syria", "+963"},
            {"Taiwan", "+886"},
            {"Tajikistan", "+992"},
            {"Tanzania", "+255"},
            {"Thailand", "+66"},
            {"Timor-Leste", "+670"},
            {"Togo", "+228"},
            {"Tokelau", "+690"},
            {"Tonga", "+676"},
            {"Trinidad and Tobago", "+1-868"},
            {"Tunisia", "+216"},
            {"Turkey", "+90"},
            {"Turkmenistan", "+993"},
            {"Turks and Caicos Islands", "+1-649"},
            {"Tuvalu", "+688"},
            {"Uganda", "+256"},
            {"Ukraine", "+380"},
            {"United Arab Emirates", "+971"},
            {"United Kingdom", "+44"},
            {"United States", "+1"},
            {"Uruguay", "+598"},
            {"Uzbekistan", "+998"},
            {"Vanuatu", "+678"},
            {"Venezuela", "+58"},
            {"Vietnam", "+84"},
            {"British Virgin Islands", "+1-284"},
            {"U.S. Virgin Islands", "+1-340"},
            {"Wallis and Futuna", "+681"},
            {"Western Sahara", "+212"},
            {"Yemen", "+967"},
            {"Zambia", "+260"},
            {"Zimbabwe", "+263"}
        };

        for (String[] countryData : countries) {
            String country = countryData[0];
            String telCode = countryData[1].replaceAll("[^0-9+]", "");
            
            CountryCode countryCode = new CountryCode();
            countryCode.setCountry(country);
            countryCode.setTelCode(telCode);
            countryCode.setCodeLength(telCode.length());
            repository.save(countryCode);
        }
        log.info("Загрузка кодов стран завершена");
    }

    @Override
    public List<CountryCode> findCountryByPhoneNumber(String phoneNumber) {
        log.info("Поиск страны для номера: {}", phoneNumber);
        
        final String normalizedNumber = (phoneNumber.startsWith("+") ? phoneNumber : "+" + phoneNumber)
                .replaceAll("[^0-9+]", "");
        
        log.info("Нормализованный номер: {}", normalizedNumber);
        
        List<CountryCode> possibleCountries = repository.findByTelCodeStartingWith(normalizedNumber);
        log.info("Найдено возможных стран: {}", possibleCountries.size());
        
        if (possibleCountries.isEmpty()) {
            String prefix = normalizedNumber.substring(0, 2);
            possibleCountries = repository.findByTelCodeStartingWith(prefix);
            log.info("Поиск по префиксу {}: найдено стран: {}", prefix, possibleCountries.size());
        }
        
        List<CountryCode> matchingCountries = possibleCountries.stream()
                .filter(country -> normalizedNumber.startsWith(country.getTelCode()))
                .collect(Collectors.toList());
                
        if (matchingCountries.isEmpty()) {
            throw new CountryNotFoundException("Страна не найдена для номера: " + phoneNumber);
        }
        
        return matchingCountries;
    }
} 