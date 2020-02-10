package com.example.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@PropertySource(value = "classpath:application.properties")
@EnableElasticsearchRepositories(basePackages = "com.example.es.repo")
@ComponentScan(basePackages = {"com.example.es.service"})
public class Esconfig {
    @Value("${elasticsearch.host}")
    private String EsHost;

    @Value("${elasticsearch.port}")
    private int EsPort;

    @Value("${elasticsearch.clustername}")
    private String EsClusterName;

    @Bean
    public RestHighLevelClient client() throws Exception {
//        Settings esSettings = Settings.builder()
//                .put("cluster.name", EsClusterName)
//                .build();
//
//        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
//                .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
//               // .addTransportAddress(new TransportAddress(InetAddress.getByName("host2"), 9300));

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"))
                        .setRequestConfigCallback(requestConfigBuilder -> requestConfigBuilder.setConnectTimeout(90000).setSocketTimeout(90000)
                                .setConnectionRequestTimeout(0))
                        .setMaxRetryTimeoutMillis(90000));


        System.out.println("Transport: " + client);

        return client;

    }

//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
//        return new ElasticsearchTemplate(client());
//    }
}
