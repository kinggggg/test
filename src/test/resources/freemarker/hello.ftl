
${hello}
---------------------------------------
如果world变量不存在的话，会报错
<#--${world}-->
不会报错
${world!}
---------------------------------------
${person}
${person.student}
<#if (person.student)??>
    存在
<#else>
    不存在
</#if>
${person.student.address}
---------------------------------------
${person1!}
<#if (person1.student)??>
    存在
    <#else>
    不存在
</#if>
${true?string('1', '5')}
---------------------------------------
${(person1.name)!"person1不存在"}
${(person1.student)!"student不存在"}
<#--${person.student.address}-->