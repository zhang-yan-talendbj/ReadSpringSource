/*
 * Copyright 2002-2012 the original author or authors. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 */

package spring.aop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.PerClauseKind;
import org.junit.Test;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.annotation.AspectMetadata;

import org.springframework.core.Ordered;

/**
 * @since 2.0
 * @author Rod Johnson
 * @author Chris Beams
 */
public final class AspectMetadataTests {

	@Test(expected = IllegalArgumentException.class)
	public void testNotAnAspect() {
		new AspectMetadata(String.class, "someBean");
	}

	@Test
	public void testSingletonAspect() {
		AspectMetadata am = new AspectMetadata(ExceptionAspect.class, "someBean");
		assertFalse(am.isPerThisOrPerTarget());
		assertSame(Pointcut.TRUE, am.getPerClausePointcut());
		assertEquals(PerClauseKind.SINGLETON, am.getAjType().getPerClause().getKind());
	}

	@Test
	public void testPerTargetAspect() {
		AspectMetadata am = new AspectMetadata(PerTargetAspect.class, "someBean");
		assertTrue(am.isPerThisOrPerTarget());
		assertNotSame(Pointcut.TRUE, am.getPerClausePointcut());
		assertEquals(PerClauseKind.PERTARGET, am.getAjType().getPerClause().getKind());
	}

//	@Test
//	public void testPerThisAspect() {
//		AspectMetadata am = new AspectMetadata(PerThisAspect.class, "someBean");
//		assertTrue(am.isPerThisOrPerTarget());
//		assertNotSame(Pointcut.TRUE, am.getPerClausePointcut());
//		assertEquals(PerClauseKind.PERTHIS, am.getAjType().getPerClause().getKind());
//	}

	@Aspect
	public static class ExceptionAspect {
		private final Exception ex;

		public ExceptionAspect(Exception ex) {
			this.ex = ex;
		}

		@Before("execution(* getAge())")
		public void throwException() throws Exception {
			throw ex;
		}
	}




}

@Aspect("pertarget(execution(* *.getSpouse()))")
class PerTargetAspect implements Ordered {

	public int count;

	private int order = Ordered.LOWEST_PRECEDENCE;

	@Around("execution(int *.getAge())")
	public int returnCountAsAge() {
		return count++;
	}

	@Before("execution(void *.set*(int))")
	public void countSetter() {
		++count;
	}

	@Override
	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
}



