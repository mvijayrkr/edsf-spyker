package com.dbs.edsf.aerospike.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.core.AerospikeTemplate;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.ClientPolicy;


@Configuration
@EnableAerospikeRepositories(basePackages = {"com.dbs.edsf.aerospike.repository"})
@EnableAutoConfiguration
@EnableTransactionManagement
public class AerospikeConfiguration {

	public @Bean(destroyMethod = "close") AerospikeClient aerospikeClient() {
		ClientPolicy policy = new ClientPolicy();
		policy.failIfNotConnected = true;

		return new AerospikeClient(policy, "192.168.110.128", 3000);
	}

	public @Bean AerospikeTemplate aerospikeTemplate() {
		return new AerospikeTemplate(aerospikeClient(), "test");
	}
}
