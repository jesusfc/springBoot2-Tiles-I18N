package com.config;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/*
By default Spring Boot will serve static content from a directory called /static (or /public or /resources or /META-INF/resources)
in the classpath or from the root of the ServletContext.
But here we have defined out custom folder structure for static contents,
hence it is required to tell Spring boot about how to render static content.
*/

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/js/*").addResourceLocations("/js/");
    registry.addResourceHandler("/css/*").addResourceLocations("/css/");
    registry.addResourceHandler("/images/*").addResourceLocations("/images/");
  }

  /** **************************************** */
  /** ****** APACHE TILES ******************** */
  /** **************************************** */

  /**
   * Initialise Tiles on application startup and identify the location of the tiles configuration
   * file, tiles.xml.
   *
   * @return tiles configurer
   */
  @Bean
  public TilesConfigurer tilesConfigurer() {

    final TilesConfigurer configurer = new TilesConfigurer();
    String[] definitions =
        new String[] {"/WEB-INF/defs/basesLayouts.xml", "/WEB-INF/defs/views.xml"};
    configurer.setDefinitions(definitions);
    configurer.setCheckRefresh(true);

    return configurer;
  }

  /**
   * Introduce a Tiles view resolver, this is a convenience implementation that extends
   * URLBasedViewResolver.
   *
   * @return tiles view resolver
   */
  @Bean
  public TilesViewResolver tilesViewResolver() {
    final TilesViewResolver resolver = new TilesViewResolver();
    resolver.setViewClass(TilesView.class);
    return resolver;
  }

  /** **************************************** */
  /** ****** INTERNACIONALIZACION I18N ******* */
  /** **************************************** */
  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:i18n/messages");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }

  @Bean
  public LocaleResolver localeResolver() {
    SessionLocaleResolver localeResolver = new SessionLocaleResolver();
    localeResolver.setDefaultLocale(Locale.getDefault());
    return localeResolver;
  }

  @Bean
  public LocaleChangeInterceptor localeChangeInterceptor() {
    LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
    localeInterceptor.setIgnoreInvalidLocale(true);
    localeInterceptor.setParamName("lang");
    return localeInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(localeChangeInterceptor());
  }

}
