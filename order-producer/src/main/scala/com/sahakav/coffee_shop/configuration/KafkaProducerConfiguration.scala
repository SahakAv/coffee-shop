package com.sahakav.coffee_shop.configuration

import java.util

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.core.{DefaultKafkaProducerFactory, KafkaTemplate}
import org.springframework.kafka.support.serializer.JsonSerializer

@Configuration
@EnableKafka
class KafkaProducerConfiguration {
  @Value("${kafka.bootstrap.server.host}") private val bootstrapServerHost:String = null

  @Bean def producerFactory = new DefaultKafkaProducerFactory[Any, AnyRef](producerConfigs)

  @Bean def producerConfigs: util.Map[String, AnyRef] = {
    val props = new util.HashMap[String, AnyRef]
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServerHost)
    props.put(ProducerConfig.BATCH_SIZE_CONFIG, Integer.valueOf(16384))
    props.put(ProducerConfig.LINGER_MS_CONFIG, Integer.valueOf(2))
    props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, Integer.valueOf(33554432))
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer])
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[JsonSerializer[_]])
    props
  }

  @Bean def kafkaTemplate = new KafkaTemplate(producerFactory)
}
