package com.codiform.moo.source;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * A source for object translations, either new, or cached.  This is primarily to decouple the translation session from the translators
 * to reduce cycles in the layering.  That might be unnecessary, but it makes me happy.
 */
public interface TranslationSource {
	
	/**
	 * Gets a translation to a specified class from the translation session.  Attempts to load from cache,
	 * but if not present, performs a translation using a translator.
	 * 
	 * @param source the source object to be translated
	 * @param destinationClass the class to which the translation should be performed
	 * @param <T> the type that binds the return value to the destination class
	 */
	public <T> T getTranslation( Object source, Class<T> destination );
	
	/**
	 * Creates a list of translations from a list of source objects, first checking the
	 * cache and then, if needed, creating the translation.
	 * 
	 * @param sources the source objects to be translated
	 * @param destinationClass the class to which the translation should be performed
	 * @param <T> the type that binds the return values to the destination class
	 */
	public <T> List<T> getEachTranslation( List<?> source, Class<T> destinationClass );
	
	/**
	 * Creates a set of translations from a set of source objects, first checking the
	 * cache and then, if needed, creating the translation.
	 * 
	 * @param sources the source objects to be translated
	 * @param destinationClass the class to which the translation should be performed
	 * @param <T> the type that binds the return values to the destination class
	 */
	public <T> Set<T> getEachTranslation( Set<?> source, Class<T> destinationClass );
	
	/**
	 * Creates a collection of translations from a collection of source objects, first checking the
	 * cache and then, if needed, creating the translation.
	 * 
	 * @param sources the source objects to be translated
	 * @param destinationClass the class to which the translation should be performed
	 * @param <T> the type that binds the return values to the destination class
	 */
	public <T> Collection<T> getEachTranslation( Collection<?> source, Class<T> destinationClass );
	
}
