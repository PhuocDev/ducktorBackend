package com.example.docktor_mobile.ducktor.controllers;

import com.example.docktor_mobile.ducktor.models.Desease;
import com.example.docktor_mobile.ducktor.models.TopLink;
import com.example.docktor_mobile.ducktor.services.TopLinkService;
import com.example.docktor_mobile.ducktor.services.DeseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
@RequestMapping("/ducktor")
public class MainController {
    @Autowired
    TopLinkService topLinkService;

    @Autowired
    DeseaseService deseaseService;

    @GetMapping("/search")
    public ArrayList<TopLink> getTopLinksWithKeyword(@RequestParam String category) {
        ArrayList<TopLink> topLinks = new ArrayList<>();

        String uri = "https:"+"//ap"+"i.nhs.u"+"k/cond" + "itions/"+"?category=" + category + "&gen"+"re=condition&subs"+"cription-key=4d5efa5"+"f571f4c4abed9f546d9e2ab81";
        RestTemplate restTemplate = new RestTemplate();

        //get Json from api
        String jsonObject = restTemplate.getForObject(uri, String.class);

        topLinks = topLinkService.getLinksFromJson(jsonObject);

        return topLinks;
    }

    @GetMapping("/details")
    public Desease detailsDesease(@RequestParam String url) {
        Desease desease = new Desease();
        String uri2 = url + "?subsc"+"ription-key=4d5ef"+"a5f571f4c4abed9f5"+"46d9e2ab81";
        RestTemplate restTemplate = new RestTemplate();

        //get json from api
        String jsonString = restTemplate.getForObject(uri2, String.class);
        //test bằng json demo
        //jsonString = sampleJsonResult;
        //System.out.println(jsonString);
        desease = deseaseService.getInformationFromJson(jsonString);
        return desease;
    }

    @GetMapping("/test")
    public Desease detailsDeseaseTest() {
        Desease desease = new Desease();
        String uri2 = "1231" + "?subscripti"+"on-key=4d5efa5f"+"571f4c4abed9f546d9e2ab81";
        RestTemplate restTemplate = new RestTemplate();

        //get json from api
        String jsonString = sampleJsonResult ;
        //test bằng json demo
        //jsonString = sampleJsonResult;
        //System.out.println(jsonString);
        desease = deseaseService.getInformationFromJson(jsonString);
        return desease;
    }
    public static String sampleJsonResultHeadache = "{\n" +
            "    \"@context\": \"http://schema.org\",\n" +
            "    \"@type\": \"MedicalWebPage\",\n" +
            "    \"name\": \"Headaches\",\n" +
            "    \"copyrightHolder\": {\n" +
            "        \"name\": \"Crown Copyright\",\n" +
            "        \"@type\": \"Organization\"\n" +
            "    },\n" +
            "    \"license\": \"https://developer.api.nhs.uk/terms\",\n" +
            "    \"author\": {\n" +
            "        \"url\": \"https://www.nhs.uk\",\n" +
            "        \"logo\": \"https://www.nhs.uk/nhscwebservices/documents/logo1.jpg\",\n" +
            "        \"email\": \"nhswebsite.servicedesk@nhs.net\",\n" +
            "        \"@type\": \"Organization\",\n" +
            "        \"name\": \"NHS website\"\n" +
            "    },\n" +
            "    \"about\": {\n" +
            "        \"@type\": \"WebPage\",\n" +
            "        \"name\": \"Headaches\",\n" +
            "        \"alternateName\": \"\"\n" +
            "    },\n" +
            "    \"description\": \"Read about some of the main types of headaches, and find out when you should get medical advice.\",\n" +
            "    \"url\": \"https://api.nhs.uk/conditions/headaches/\",\n" +
            "    \"genre\": [\n" +
            "        \"Symptom\"\n" +
            "    ],\n" +
            "    \"keywords\": [],\n" +
            "    \"lastReviewed\": [\n" +
            "        \"2021-02-09T09:59:00+00:00\",\n" +
            "        \"2024-02-09T09:59:00+00:00\"\n" +
            "    ],\n" +
            "    \"breadcrumb\": {\n" +
            "        \"@context\": \"http://schema.org\",\n" +
            "        \"@type\": \"BreadcrumbList\",\n" +
            "        \"itemListElement\": [\n" +
            "            {\n" +
            "                \"@type\": \"ListItem\",\n" +
            "                \"position\": 0,\n" +
            "                \"item\": {\n" +
            "                    \"@id\": \"https://api.nhs.uk/conditions/\",\n" +
            "                    \"name\": \"Health A to Z\",\n" +
            "                    \"genre\": []\n" +
            "                }\n" +
            "            },\n" +
            "            {\n" +
            "                \"@type\": \"ListItem\",\n" +
            "                \"position\": 1,\n" +
            "                \"item\": {\n" +
            "                    \"@id\": \"https://api.nhs.uk/conditions/headaches/\",\n" +
            "                    \"name\": \"Headaches\",\n" +
            "                    \"genre\": [\n" +
            "                        \"Symptom\"\n" +
            "                    ]\n" +
            "                }\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"dateModified\": \"2022-05-06T13:14:01+00:00\",\n" +
            "    \"hasPart\": [\n" +
            "        {\n" +
            "            \"@type\": \"HealthTopicContent\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/headaches/#self-care\",\n" +
            "            \"hasHealthAspect\": \"http://schema.org/SelfCareHealthAspect\",\n" +
            "            \"headline\": \"How you can ease headaches yourself\",\n" +
            "            \"description\": \"To help ease a headache, drink plenty of water, try to rest and relax, and take paracetamol and ibuprofen if you need to.\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"headline\": \"\",\n" +
            "                    \"text\": \"<p>Headaches can last between 30 minutes and several hours.</p>\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"headline\": \"Do\",\n" +
            "                    \"text\": \"<ul><li><p>drink plenty of water</p></li><li><p>get plenty of rest if you have a cold or the flu</p></li><li><p>try to relax – stress can make headaches worse</p></li><li><p>take <a href=\\\"/medicines/paracetamol-for-adults-old/\\\">paracetamol</a> or <a href=\\\"/medicines/ibuprofen-for-adults/\\\">ibuprofen</a></p></li><li><p>try to stay at home and avoid contact with other people if you have a high temperature or you do not feel well enough to do your normal activities</p></li></ul>\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"headline\": \"Don't\",\n" +
            "                    \"text\": \"<ul><li><p>do not drink alcohol</p></li><li><p>do not skip meals (even if you might not feel like eating anything)</p></li><li><p>do not sleep more than you usually would – it can make the headache worse</p></li><li><p>do not strain your eyes for a long time – for example, by looking at a screen</p></li></ul>\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"HealthTopicContent\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/headaches/#non-urgent-medical-help\",\n" +
            "            \"hasHealthAspect\": \"http://schema.org/MedicalHelpNonurgentHealthAspect\",\n" +
            "            \"headline\": \"\",\n" +
            "            \"description\": \"\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"identifier\": \"primary\",\n" +
            "                    \"headline\": \"See a GP if:\",\n" +
            "                    \"text\": \"<ul>\\n<li>\\n  your headache keeps coming back\\n </li>\\n<li>\\n  painkillers do not help and your headache gets worse\\n </li>\\n<li>\\n  you have a bad throbbing pain at the front or side of your head – it could be a\\n  <a href=\\\"https://api.nhs.uk/conditions/migraine/\\\">\\n   migraine\\n  </a>\\n  or, more rarely, a\\n  <a href=\\\"https://api.nhs.uk/conditions/cluster-headaches/\\\">\\n   cluster headache\\n  </a>\\n</li>\\n<li>\\n  you feel sick, vomit and find light or noise painful\\n </li>\\n</ul>\\n\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"HealthTopicContent\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/headaches/#urgent-medical-help\",\n" +
            "            \"hasHealthAspect\": \"http://schema.org/MedicalHelpUrgentHealthAspect\",\n" +
            "            \"headline\": \"\",\n" +
            "            \"description\": \"\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"identifier\": \"urgent\",\n" +
            "                    \"headline\": \"Get an urgent GP appointment or call 111 if:\",\n" +
            "                    \"text\": \"<p>\\n You or your child has a severe headache and:\\n</p>\\n<ul>\\n<li>\\n  jaw pain when eating\\n </li>\\n<li>\\n  blurred or double vision\\n </li>\\n<li>\\n  a sore scalp\\n </li>\\n<li>\\n  other symptoms, such as numbness or weakness in the arms or legs\\n </li>\\n</ul>\\n<p>\\n Also get an urgent GP appointment or call 111 if your child is under 12 and has any 1 of the following:\\n</p>\\n<ul>\\n<li>\\n  a headache that wakes them at night\\n </li>\\n<li>\\n  a headache when they wake up in the morning\\n </li>\\n<li>\\n  a headache that gets progressively worse\\n </li>\\n<li>\\n  a headache triggered or made worse by coughing, sneezing or bending down\\n </li>\\n<li>\\n  a headache with vomiting\\n </li>\\n<li>\\n  a headache with a\\n  <a href=\\\"https://api.nhs.uk/conditions/squint/\\\">\\n   squint\\n  </a>\\n  (where the eyes point in different directions) or an inability to look upward\\n </li>\\n</ul>\\n<p>\\n You can\\n <a href=\\\"tel:111\\\">\\n  call 111\\n </a>\\n or\\n <a href=\\\"https://111.nhs.uk/?utm_source=nhsuk&amp;utm_campaign=conditions&amp;utm_content=headaches\\\">\\n  get help from 111 online\\n </a>\\n .\\n</p>\\n\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"HealthTopicContent\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/headaches/#emergency-medical-help\",\n" +
            "            \"hasHealthAspect\": \"http://schema.org/MedicalHelpEmergencyHealthAspect\",\n" +
            "            \"headline\": \"\",\n" +
            "            \"description\": \"\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"identifier\": \"immediate\",\n" +
            "                    \"headline\": \"Call 999 or go to A&E if you or your child:\",\n" +
            "                    \"text\": \"<ul>\\n<li>\\n  has a head injury – for example, from a fall or accident\\n </li>\\n<li>\\n  has a headache that came on suddenly and is extremely painful\\n </li>\\n</ul>\\n<p>\\n You or your child has an extremely painful headache and:\\n</p>\\n<ul>\\n<li>\\n  sudden problems speaking or remembering things\\n </li>\\n<li>\\n  loss of vision\\n </li>\\n<li>\\n  feel drowsy or confused\\n </li>\\n<li>\\n  has a very high temperature and\\n  <a href=\\\"https://api.nhs.uk/conditions/meningitis/symptoms/\\\">\\n   symptoms of meningitis\\n  </a>\\n</li>\\n<li>\\n  the white part of the eye is red\\n </li>\\n</ul>\\n<p>\\n Also call 999 or go to A&amp;E if your child is under 12 and has any 1 of the following:\\n</p>\\n<ul>\\n<li>\\n  a headache with vision problems or difficulty speaking, swallowing, balancing or walking\\n </li>\\n<li>\\n  a headache with drowsiness or a persistent lack of energy\\n </li>\\n<li>\\n  a headache that starts within 5 days of a head injury\\n </li>\\n</ul>\\n\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"HealthTopicContent\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/headaches/#causes\",\n" +
            "            \"hasHealthAspect\": \"http://schema.org/CausesHealthAspect\",\n" +
            "            \"headline\": \"What can cause headaches\",\n" +
            "            \"description\": \"Common causes of headaches include having a cold or flu, stress, drinking too much alcohol and eyesight problems.\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"headline\": \"\",\n" +
            "                    \"text\": \"<p>The most common reasons are:</p><ul><li>having a <a href=\\\"https://api.nhs.uk/conditions/common-cold/\\\">cold</a> or <a href=\\\"https://api.nhs.uk/conditions/flu/\\\">flu</a></li><li>stress</li><li>drinking too much alcohol</li><li>bad posture</li><li>eyesight problems</li><li>not eating regular meals</li><li>not drinking enough fluids (dehydration)</li><li>taking too many painkillers</li><li>having your period or during menopause</li></ul>\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"HealthTopicContent\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/headaches/#overview\",\n" +
            "            \"hasHealthAspect\": \"http://schema.org/OverviewHealthAspect\",\n" +
            "            \"headline\": \"\",\n" +
            "            \"description\": \"Most headaches go away on their own and are not a sign of something more serious. There are things you can do to help ease a headache.\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"text\": \"<p>Common causes of headaches include having a cold or flu, stress, drinking too much alcohol and eyesight problems.</p> \",\n" +
            "                    \"@type\": \"WebPageElement\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"text\": \"<p>To help ease a headache, drink plenty of water, try to rest and relax, and take paracetamol and ibuprofen if you need to.</p> \",\n" +
            "                    \"@type\": \"WebPageElement\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ],\n" +
            "    \"relatedLink\": [\n" +
            "        {\n" +
            "            \"@type\": \"LinkRole\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/headaches/\",\n" +
            "            \"linkRelationship\": \"Navigation\",\n" +
            "            \"position\": 0,\n" +
            "            \"name\": \"Headaches\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"contentSubTypes\": [],\n" +
            "    \"mainEntityOfPage\": [\n" +
            "        {\n" +
            "            \"identifier\": \"0\",\n" +
            "            \"name\": \"section heading\",\n" +
            "            \"position\": 0,\n" +
            "            \"@type\": \"WebPageElement\",\n" +
            "            \"mainEntityOfPage\": [\n" +
            "                {\n" +
            "                    \"position\": 0,\n" +
            "                    \"identifier\": \"1\",\n" +
            "                    \"text\": \"<p><b>Most headaches go away on their own and are not a sign of something more serious.</b></p>\",\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"markdown\",\n" +
            "                    \"headline\": \"\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"description\": \"\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"position\": 0,\n" +
            "                    \"identifier\": \"1\",\n" +
            "                    \"text\": \"<p><b>Most headaches go away on their own and are not a sign of something more serious.</b></p>\",\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"markdown\",\n" +
            "                    \"headline\": \"\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"identifier\": \"0\",\n" +
            "            \"name\": \"section heading\",\n" +
            "            \"position\": 1,\n" +
            "            \"@type\": \"WebPageElement\",\n" +
            "            \"mainEntityOfPage\": [\n" +
            "                {\n" +
            "                    \"position\": 0,\n" +
            "                    \"identifier\": \"1\",\n" +
            "                    \"text\": \"<p>Headaches can last between 30 minutes and several hours.</p>\",\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"markdown\",\n" +
            "                    \"headline\": \"\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"position\": 1,\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"Do/Don't\",\n" +
            "                    \"identifier\": \"9\",\n" +
            "                    \"text\": \"<div><h3>Do</h3><ul><li><p>drink plenty of water</p></li><li><p>get plenty of rest if you have a cold or the flu</p></li><li><p>try to relax – stress can make headaches worse</p></li><li><p>take <a href=\\\"/medicines/paracetamol-for-adults-old/\\\">paracetamol</a> or <a href=\\\"/medicines/ibuprofen-for-adults/\\\">ibuprofen</a></p></li><li><p>try to stay at home and avoid contact with other people if you have a high temperature or you do not feel well enough to do your normal activities</p></li></ul></div>\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"position\": 2,\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"Do/Don't\",\n" +
            "                    \"identifier\": \"9\",\n" +
            "                    \"text\": \"<div><h3>Don't</h3><ul><li><p>do not drink alcohol</p></li><li><p>do not skip meals (even if you might not feel like eating anything)</p></li><li><p>do not sleep more than you usually would – it can make the headache worse</p></li><li><p>do not strain your eyes for a long time – for example, by looking at a screen</p></li></ul></div>\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"description\": \"To help ease a headache, drink plenty of water, try to rest and relax, and take paracetamol and ibuprofen if you need to.\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"position\": 0,\n" +
            "                    \"identifier\": \"1\",\n" +
            "                    \"text\": \"<p>Headaches can last between 30 minutes and several hours.</p>\",\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"markdown\",\n" +
            "                    \"headline\": \"\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"position\": 1,\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"Do/Don't\",\n" +
            "                    \"identifier\": \"9\",\n" +
            "                    \"text\": \"<div><h3>Do</h3><ul><li><p>drink plenty of water</p></li><li><p>get plenty of rest if you have a cold or the flu</p></li><li><p>try to relax – stress can make headaches worse</p></li><li><p>take <a href=\\\"/medicines/paracetamol-for-adults-old/\\\">paracetamol</a> or <a href=\\\"/medicines/ibuprofen-for-adults/\\\">ibuprofen</a></p></li><li><p>try to stay at home and avoid contact with other people if you have a high temperature or you do not feel well enough to do your normal activities</p></li></ul></div>\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"position\": 2,\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"Do/Don't\",\n" +
            "                    \"identifier\": \"9\",\n" +
            "                    \"text\": \"<div><h3>Don't</h3><ul><li><p>do not drink alcohol</p></li><li><p>do not skip meals (even if you might not feel like eating anything)</p></li><li><p>do not sleep more than you usually would – it can make the headache worse</p></li><li><p>do not strain your eyes for a long time – for example, by looking at a screen</p></li></ul></div>\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"hasHealthAspect\": \"http://schema.org/SelfCareHealthAspect\",\n" +
            "            \"headline\": \"How you can ease headaches yourself\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"identifier\": \"0\",\n" +
            "            \"name\": \"section heading\",\n" +
            "            \"position\": 2,\n" +
            "            \"@type\": \"WebPageElement\",\n" +
            "            \"mainEntityOfPage\": [],\n" +
            "            \"description\": \"\",\n" +
            "            \"hasPart\": []\n" +
            "        },\n" +
            "        {\n" +
            "            \"identifier\": \"0\",\n" +
            "            \"name\": \"section heading\",\n" +
            "            \"position\": 3,\n" +
            "            \"@type\": \"WebPageElement\",\n" +
            "            \"mainEntityOfPage\": [\n" +
            "                {\n" +
            "                    \"position\": 0,\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"non-urgent\",\n" +
            "                    \"identifier\": \"5\",\n" +
            "                    \"text\": \"<h2>See a GP if:</h2><div class=\\\"block-richtext\\\">\\n<ul><li>your headache keeps coming back</li><li>painkillers do not help and your headache gets worse</li><li>you have a bad throbbing pain at the front or side of your head – it could be a <a href=\\\"https://api.nhs.uk/conditions/migraine/\\\">migraine</a> or, more rarely, a <a href=\\\"https://api.nhs.uk/conditions/cluster-headaches/\\\">cluster headache</a></li><li>you feel sick, vomit and find light or noise painful</li></ul>\\n</div>\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"description\": \"\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"position\": 0,\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"non-urgent\",\n" +
            "                    \"identifier\": \"5\",\n" +
            "                    \"text\": \"<h2>See a GP if:</h2><div class=\\\"block-richtext\\\">\\n<ul><li>your headache keeps coming back</li><li>painkillers do not help and your headache gets worse</li><li>you have a bad throbbing pain at the front or side of your head – it could be a <a href=\\\"https://api.nhs.uk/conditions/migraine/\\\">migraine</a> or, more rarely, a <a href=\\\"https://api.nhs.uk/conditions/cluster-headaches/\\\">cluster headache</a></li><li>you feel sick, vomit and find light or noise painful</li></ul>\\n</div>\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"hasHealthAspect\": \"http://schema.org/MedicalHelpNonurgentHealthAspect\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"identifier\": \"0\",\n" +
            "            \"name\": \"section heading\",\n" +
            "            \"position\": 4,\n" +
            "            \"@type\": \"WebPageElement\",\n" +
            "            \"mainEntityOfPage\": [\n" +
            "                {\n" +
            "                    \"position\": 0,\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"urgent\",\n" +
            "                    \"identifier\": \"5\",\n" +
            "                    \"text\": \"<h2>Get an urgent GP appointment or call 111 if:</h2><div class=\\\"block-richtext\\\">\\n<p>You or your child has a severe headache and:</p><ul><li>jaw pain when eating</li><li>blurred or double vision</li><li>a sore scalp</li><li>other symptoms, such as numbness or weakness in the arms or legs</li></ul><p>Also get an urgent GP appointment or call 111 if your child is under 12 and has any 1 of the following:</p><ul><li>a headache that wakes them at night</li><li>a headache when they wake up in the morning</li><li>a headache that gets progressively worse</li><li>a headache triggered or made worse by coughing, sneezing or bending down</li><li>a headache with vomiting</li><li>a headache with a <a href=\\\"https://api.nhs.uk/conditions/squint/\\\">squint</a> (where the eyes point in different directions) or an inability to look upward</li></ul><p>You can <a href=\\\"tel:111\\\">call 111</a> or <a href=\\\"https://111.nhs.uk/?utm_source=nhsuk&amp;utm_campaign=conditions&amp;utm_content=headaches\\\">get help from 111 online</a>.</p>\\n</div>\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"description\": \"\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"position\": 0,\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"urgent\",\n" +
            "                    \"identifier\": \"5\",\n" +
            "                    \"text\": \"<h2>Get an urgent GP appointment or call 111 if:</h2><div class=\\\"block-richtext\\\">\\n<p>You or your child has a severe headache and:</p><ul><li>jaw pain when eating</li><li>blurred or double vision</li><li>a sore scalp</li><li>other symptoms, such as numbness or weakness in the arms or legs</li></ul><p>Also get an urgent GP appointment or call 111 if your child is under 12 and has any 1 of the following:</p><ul><li>a headache that wakes them at night</li><li>a headache when they wake up in the morning</li><li>a headache that gets progressively worse</li><li>a headache triggered or made worse by coughing, sneezing or bending down</li><li>a headache with vomiting</li><li>a headache with a <a href=\\\"https://api.nhs.uk/conditions/squint/\\\">squint</a> (where the eyes point in different directions) or an inability to look upward</li></ul><p>You can <a href=\\\"tel:111\\\">call 111</a> or <a href=\\\"https://111.nhs.uk/?utm_source=nhsuk&amp;utm_campaign=conditions&amp;utm_content=headaches\\\">get help from 111 online</a>.</p>\\n</div>\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"hasHealthAspect\": \"http://schema.org/MedicalHelpUrgentHealthAspect\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"identifier\": \"0\",\n" +
            "            \"name\": \"section heading\",\n" +
            "            \"position\": 5,\n" +
            "            \"@type\": \"WebPageElement\",\n" +
            "            \"mainEntityOfPage\": [\n" +
            "                {\n" +
            "                    \"position\": 0,\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"immediate\",\n" +
            "                    \"identifier\": \"5\",\n" +
            "                    \"text\": \"<h2>Call 999 or go to A&amp;E if you or your child:</h2><div class=\\\"block-richtext\\\">\\n<ul><li>has a head injury – for example, from a fall or accident</li><li>has a headache that came on suddenly and is extremely painful</li></ul><p>You or your child has an extremely painful headache and:</p><ul><li>sudden problems speaking or remembering things</li><li>loss of vision</li><li>feel drowsy or confused</li><li>has a very high temperature and <a href=\\\"https://api.nhs.uk/conditions/meningitis/symptoms/\\\">symptoms of meningitis</a></li><li>the white part of the eye is red</li></ul><p>Also call 999 or go to A&amp;E if your child is under 12 and has any 1 of the following:</p><ul><li>a headache with vision problems or difficulty speaking, swallowing, balancing or walking</li><li>a headache with drowsiness or a persistent lack of energy</li><li>a headache that starts within 5 days of a head injury</li></ul>\\n</div>\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"description\": \"\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"position\": 0,\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"immediate\",\n" +
            "                    \"identifier\": \"5\",\n" +
            "                    \"text\": \"<h2>Call 999 or go to A&amp;E if you or your child:</h2><div class=\\\"block-richtext\\\">\\n<ul><li>has a head injury – for example, from a fall or accident</li><li>has a headache that came on suddenly and is extremely painful</li></ul><p>You or your child has an extremely painful headache and:</p><ul><li>sudden problems speaking or remembering things</li><li>loss of vision</li><li>feel drowsy or confused</li><li>has a very high temperature and <a href=\\\"https://api.nhs.uk/conditions/meningitis/symptoms/\\\">symptoms of meningitis</a></li><li>the white part of the eye is red</li></ul><p>Also call 999 or go to A&amp;E if your child is under 12 and has any 1 of the following:</p><ul><li>a headache with vision problems or difficulty speaking, swallowing, balancing or walking</li><li>a headache with drowsiness or a persistent lack of energy</li><li>a headache that starts within 5 days of a head injury</li></ul>\\n</div>\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"hasHealthAspect\": \"http://schema.org/MedicalHelpEmergencyHealthAspect\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"identifier\": \"0\",\n" +
            "            \"name\": \"section heading\",\n" +
            "            \"position\": 6,\n" +
            "            \"@type\": \"WebPageElement\",\n" +
            "            \"mainEntityOfPage\": [\n" +
            "                {\n" +
            "                    \"position\": 0,\n" +
            "                    \"identifier\": \"1\",\n" +
            "                    \"text\": \"<p>The most common reasons are:</p><ul><li>having a <a href=\\\"https://api.nhs.uk/conditions/common-cold/\\\">cold</a> or <a href=\\\"https://api.nhs.uk/conditions/flu/\\\">flu</a></li><li>stress</li><li>drinking too much alcohol</li><li>bad posture</li><li>eyesight problems</li><li>not eating regular meals</li><li>not drinking enough fluids (dehydration)</li><li>taking too many painkillers</li><li>having your period or during menopause</li></ul>\",\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"markdown\",\n" +
            "                    \"headline\": \"\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"description\": \"Common causes of headaches include having a cold or flu, stress, drinking too much alcohol and eyesight problems.\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"position\": 0,\n" +
            "                    \"identifier\": \"1\",\n" +
            "                    \"text\": \"<p>The most common reasons are:</p><ul><li>having a <a href=\\\"https://api.nhs.uk/conditions/common-cold/\\\">cold</a> or <a href=\\\"https://api.nhs.uk/conditions/flu/\\\">flu</a></li><li>stress</li><li>drinking too much alcohol</li><li>bad posture</li><li>eyesight problems</li><li>not eating regular meals</li><li>not drinking enough fluids (dehydration)</li><li>taking too many painkillers</li><li>having your period or during menopause</li></ul>\",\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"markdown\",\n" +
            "                    \"headline\": \"\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"hasHealthAspect\": \"http://schema.org/CausesHealthAspect\",\n" +
            "            \"headline\": \"What can cause headaches\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";
    public static String sampleJsonResult = "{\n" +
            "    \"@context\": \"http://schema.org\",\n" +
            "    \"@type\": \"MedicalWebPage\",\n" +
            "    \"name\": \"Anal cancer\",\n" +
            "    \"copyrightHolder\": {\n" +
            "        \"name\": \"Crown Copyright\",\n" +
            "        \"@type\": \"Organization\"\n" +
            "    },\n" +
            "    \"license\": \"https://developer.api.nhs.uk/terms\",\n" +
            "    \"author\": {\n" +
            "        \"url\": \"https://www.nhs.uk\",\n" +
            "        \"logo\": \"https://www.nhs.uk/nhscwebservices/documents/logo1.jpg\",\n" +
            "        \"email\": \"nhswebsite.servicedesk@nhs.net\",\n" +
            "        \"@type\": \"Organization\",\n" +
            "        \"name\": \"NHS website\"\n" +
            "    },\n" +
            "    \"about\": {\n" +
            "        \"@type\": \"WebPage\",\n" +
            "        \"name\": \"Anal cancer\",\n" +
            "        \"alternateName\": \"\"\n" +
            "    },\n" +
            "    \"description\": \"Anal cancer is a rare type of cancer that affects the anus. Get information and advice about symptoms, causes and treatments.\",\n" +
            "    \"url\": \"https://api.nhs.uk/conditions/anal-cancer/\",\n" +
            "    \"genre\": [\n" +
            "        \"Condition\"\n" +
            "    ],\n" +
            "    \"keywords\": [],\n" +
            "    \"lastReviewed\": [\n" +
            "        \"2021-03-08T01:00:00+00:00\",\n" +
            "        \"2024-03-08T01:00:00+00:00\"\n" +
            "    ],\n" +
            "    \"breadcrumb\": {\n" +
            "        \"@context\": \"http://schema.org\",\n" +
            "        \"@type\": \"BreadcrumbList\",\n" +
            "        \"itemListElement\": [\n" +
            "            {\n" +
            "                \"@type\": \"ListItem\",\n" +
            "                \"position\": 0,\n" +
            "                \"item\": {\n" +
            "                    \"@id\": \"https://api.nhs.uk/conditions/\",\n" +
            "                    \"name\": \"Health A to Z\",\n" +
            "                    \"genre\": []\n" +
            "                }\n" +
            "            },\n" +
            "            {\n" +
            "                \"@type\": \"ListItem\",\n" +
            "                \"position\": 1,\n" +
            "                \"item\": {\n" +
            "                    \"@id\": \"https://api.nhs.uk/conditions/anal-cancer/\",\n" +
            "                    \"name\": \"Anal cancer\",\n" +
            "                    \"genre\": [\n" +
            "                        \"Condition\"\n" +
            "                    ]\n" +
            "                }\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"dateModified\": \"2022-07-12T15:04:44+00:00\",\n" +
            "    \"hasPart\": [\n" +
            "        {\n" +
            "            \"@type\": \"HealthTopicContent\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/#overview\",\n" +
            "            \"hasHealthAspect\": \"http://schema.org/OverviewHealthAspect\",\n" +
            "            \"headline\": \"\",\n" +
            "            \"description\": \"Anal cancer is a rare type of cancer that affects the anus (where your bowel connects to the outside of your body).\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"text\": \"<p>Symptoms of anal cancer include bleeding, discharge, lumps and itching inside and outside the anus.</p> \",\n" +
            "                    \"@type\": \"WebPageElement\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"text\": \"<p>Anal cancer can usually be treated with chemotherapy, radiotherapy or surgery, depending on the size of the cancer and how far it has spread.</p> \",\n" +
            "                    \"@type\": \"WebPageElement\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"text\": \"<p>Most anal cancers are caused by human papillomavirus (HPV). HPV is a common virus you can get from sex or skin-to-skin contact of the genital area.</p> \",\n" +
            "                    \"@type\": \"WebPageElement\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"HealthTopicContent\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/symptoms/#symptoms\",\n" +
            "            \"hasHealthAspect\": \"http://schema.org/SymptomsHealthAspect\",\n" +
            "            \"headline\": \"Main symptoms of anal cancer\",\n" +
            "            \"description\": \"Symptoms of anal cancer include bleeding, discharge, lumps and itching inside and outside the anus.\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"headline\": \"\",\n" +
            "                    \"text\": \"<p>Symptoms of anal cancer can include:</p><ul><li>bleeding from the bottom</li><li>itching and <a href=\\\"https://api.nhs.uk/conditions/anal-pain/\\\">pain around the anus</a></li><li>small lumps around and inside the bottom</li><li>a discharge of mucus from the bottom</li><li>having problems controlling when you poo (<a href=\\\"https://api.nhs.uk/conditions/bowel-incontinence/\\\">bowel incontinence</a>)</li><li>needing to poo often with looser, runnier poos</li></ul><p>Anal cancer may have no symptoms at all, or they might be hard to spot.</p><p>Anal cancer symptoms are often similar to piles (<a href=\\\"https://api.nhs.uk/conditions/piles-haemorrhoids/\\\">haemorrhoids</a>) and <a href=\\\"https://api.nhs.uk/conditions/anal-fissure/\\\">anal fissures</a>, which are common and less serious conditions.</p>\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"HealthTopicContent\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/symptoms/#non-urgent-medical-help\",\n" +
            "            \"hasHealthAspect\": \"http://schema.org/MedicalHelpNonurgentHealthAspect\",\n" +
            "            \"headline\": \"\",\n" +
            "            \"description\": \"\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"identifier\": \"primary\",\n" +
            "                    \"headline\": \"See a GP if you:\",\n" +
            "                    \"text\": \"<ul>\\n<li>\\n  have symptoms of anal cancer\\n </li>\\n<li>\\n  notice a change around your anus that is not normal for you\\n </li>\\n</ul>\\n\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"HealthTopicContent\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/causes/#causes\",\n" +
            "            \"hasHealthAspect\": \"http://schema.org/CausesHealthAspect\",\n" +
            "            \"headline\": \"Who is more likely to get anal cancer\",\n" +
            "            \"description\": \"Most anal cancers are caused by human papillomavirus (HPV). HPV is a common virus you can get from sex or skin-to-skin contact of the genital area.\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"headline\": \"\",\n" +
            "                    \"text\": \"<p></p><p>Most anal cancers are caused by an infection called <a href=\\\"https://api.nhs.uk/conditions/human-papilloma-virus-hpv/\\\">human papillomavirus (HPV</a>).</p><p>You can get HPV from:</p><ul><li>any skin-to-skin contact of the genital area</li><li>vaginal, anal or oral sex</li><li>sharing sex toys</li></ul><p>Anal cancer is rare. Most people affected by HPV will not develop cancer.</p><p>You may be more likely to get anal cancer if you:</p><ul><li>have anal sex</li><li>are over the age of 75</li><li>smoke</li><li>have had cervical or vaginal cancer</li><li>have a weakened immune system, such as from HIV or an organ transplant</li></ul><p></p>\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"HealthTopicContent\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/causes/#prevention\",\n" +
            "            \"hasHealthAspect\": \"http://schema.org/PreventionHealthAspect\",\n" +
            "            \"headline\": \"How to reduce your risk of getting anal cancer\",\n" +
            "            \"description\": \"It’s not always possible to prevent anal cancer. Having the HPV vaccine, using a condom during sex and quitting smoking may help.\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"headline\": \"\",\n" +
            "                    \"text\": \"<p>You cannot always prevent anal cancer. HPV vaccination is one of the best ways to protect against anal cancer.</p><p>All children aged 12 to 13 are offered the <a href=\\\"https://api.nhs.uk/conditions/vaccinations/hpv-human-papillomavirus-vaccine/\\\">HPV vaccine</a>. It helps protect against cancers caused by HPV, as well as genital warts.</p><p>There are also healthy changes you can make to lower your chances of getting anal cancer.</p>\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"headline\": \"Do\",\n" +
            "                    \"text\": \"<ul><li><p>use a condom when having sex to lower your chances of getting <a href=\\\"https://api.nhs.uk/conditions/human-papilloma-virus-hpv/\\\">HPV</a></p></li><li><p>keep sex toys clean and do not share them</p></li><li><p>try to <a href=\\\"https://www.nhs.uk/live-well/quit-smoking/\\\">quit smoking</a></p></li></ul>\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"HealthTopicContent\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/tests-and-next-steps/#diagnosis\",\n" +
            "            \"hasHealthAspect\": \"http://schema.org/DiagnosisHealthAspect\",\n" +
            "            \"headline\": \"Main tests for anal cancer\",\n" +
            "            \"description\": \"To check for anal cancer, you may have a test where a thin tube with a camera is put into your bottom and a small sample from your anus is removed.\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"headline\": \"\",\n" +
            "                    \"text\": \"<p>You might have some tests and scans to check for anal cancer if a GP refers you to a specialist.</p><p>The tests you have will depend on your symptoms.</p><p>The tests may include:</p><ul><li>putting a thin tube with a camera and light into your bottom to check for any changes</li><li>taking a small sample from your anus (<a href=\\\"https://api.nhs.uk/conditions/biopsy/\\\">biopsy</a>) so it can be looked at in a laboratory under a microscope</li><li>blood tests</li></ul>\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"HealthTopicContent\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/treatment/#medical-treatments\",\n" +
            "            \"hasHealthAspect\": \"http://schema.org/TreatmentsHealthAspect\",\n" +
            "            \"headline\": \"Treatment for anal cancer\",\n" +
            "            \"description\": \"Anal cancer can usually be treated with chemotherapy, radiotherapy or surgery, depending on the size of the cancer and how far it has spread.\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"headline\": \"\",\n" +
            "                    \"text\": \"<p>Anal cancer is often treatable when found early.</p><p>The treatment you have for anal cancer will depend on:</p><ul><li>the size of the cancer</li><li>where it is</li><li>if it has spread</li><li>your general health</li></ul><p></p><p>The main treatment for anal cancer is a combination of radiotherapy and chemotherapy, called chemoradiation (or chemoradiotherapy).</p><p>Other treatments include chemotherapy or radiotherapy on their own, and surgery.</p><p>The specialist care team looking after you will:</p><ul><li>explain the treatments, benefits and side effects</li><li>work with you to create a treatment plan that is best for you</li><li>help you manage any side effects, including any changes to your diet</li></ul><p>You'll have regular check-ups during and after any treatments. You may also have tests and scans.</p><p>If you have any symptoms or side effects that you are worried about, talk to your specialists. You do not need to wait for your next check-up.</p><p></p>\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ],\n" +
            "    \"relatedLink\": [\n" +
            "        {\n" +
            "            \"@type\": \"LinkRole\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/\",\n" +
            "            \"linkRelationship\": \"Navigation\",\n" +
            "            \"position\": 0,\n" +
            "            \"name\": \"Anal cancer\",\n" +
            "            \"alternativeHeadline\": \"Overview\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"LinkRole\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/symptoms/\",\n" +
            "            \"linkRelationship\": \"Navigation\",\n" +
            "            \"position\": 1,\n" +
            "            \"name\": \"Symptoms\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"LinkRole\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/causes/\",\n" +
            "            \"linkRelationship\": \"Navigation\",\n" +
            "            \"position\": 2,\n" +
            "            \"name\": \"Causes\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"LinkRole\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/tests-and-next-steps/\",\n" +
            "            \"linkRelationship\": \"Navigation\",\n" +
            "            \"position\": 3,\n" +
            "            \"name\": \"Tests and next steps\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"LinkRole\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/treatment/\",\n" +
            "            \"linkRelationship\": \"Navigation\",\n" +
            "            \"position\": 4,\n" +
            "            \"name\": \"Treatment\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"@type\": \"LinkRole\",\n" +
            "            \"url\": \"https://api.nhs.uk/conditions/anal-cancer/where-to-find-help-and-support/\",\n" +
            "            \"linkRelationship\": \"Navigation\",\n" +
            "            \"position\": 5,\n" +
            "            \"name\": \"Where to find help and support\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"contentSubTypes\": [],\n" +
            "    \"mainEntityOfPage\": [\n" +
            "        {\n" +
            "            \"identifier\": \"0\",\n" +
            "            \"name\": \"section heading\",\n" +
            "            \"position\": 0,\n" +
            "            \"@type\": \"WebPageElement\",\n" +
            "            \"mainEntityOfPage\": [\n" +
            "                {\n" +
            "                    \"position\": 0,\n" +
            "                    \"identifier\": \"1\",\n" +
            "                    \"text\": \"<ul><li>Anal cancer is a rare type of cancer that affects the anus.</li><li>The anus is where your bowel connects to the outside of your body (the bottom).</li><li>Anal cancer can start in any part of the anus.</li><li>How serious anal cancer is depends on where it starts, how big it is, if it spreads and your general health.</li></ul>\",\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"markdown\",\n" +
            "                    \"headline\": \"\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"description\": \"\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"position\": 0,\n" +
            "                    \"identifier\": \"1\",\n" +
            "                    \"text\": \"<ul><li>Anal cancer is a rare type of cancer that affects the anus.</li><li>The anus is where your bowel connects to the outside of your body (the bottom).</li><li>Anal cancer can start in any part of the anus.</li><li>How serious anal cancer is depends on where it starts, how big it is, if it spreads and your general health.</li></ul>\",\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"markdown\",\n" +
            "                    \"headline\": \"\"\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"identifier\": \"0\",\n" +
            "            \"name\": \"section heading\",\n" +
            "            \"position\": 1,\n" +
            "            \"@type\": \"WebPageElement\",\n" +
            "            \"mainEntityOfPage\": [\n" +
            "                {\n" +
            "                    \"position\": 0,\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"Callout\",\n" +
            "                    \"identifier\": \"4\",\n" +
            "                    \"text\": \"<h2>Get your symptoms checked</h2><p>It's important to get any symptoms of anal cancer checked as soon as possible. Finding it early can make it more treatable.</p>\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"description\": \"\",\n" +
            "            \"hasPart\": [\n" +
            "                {\n" +
            "                    \"position\": 0,\n" +
            "                    \"@type\": \"WebPageElement\",\n" +
            "                    \"name\": \"Callout\",\n" +
            "                    \"identifier\": \"4\",\n" +
            "                    \"text\": \"<h2>Get your symptoms checked</h2><p>It's important to get any symptoms of anal cancer checked as soon as possible. Finding it early can make it more treatable.</p>\"\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ],\n" +
            "    \"alternativeHeadline\": \"Overview\"\n" +
            "}";
}
