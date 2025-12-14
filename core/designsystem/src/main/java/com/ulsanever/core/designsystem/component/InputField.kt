package com.ulsanever.core.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ulsanever.core.designsystem.R
import com.ulsanever.core.designsystem.icon.LangChatIcons
import com.ulsanever.core.designsystem.theme.LangChatTheme
import com.ulsanever.core.designsystem.theme.LangChatTypography

/**
 * LangChat 입력창. Material 3 [OutlinedTextField] 래핑
 *
 * @param value 입력창에 표시되는 텍스트
 * @param onValueChange 텍스트 변경 시 호출되는 콜백
 * @param modifier 입력창 modifier
 * @param enabled 입력창 활성화 여부
 * @param label 입력창 위에 표시되는 텍스트
 * @param placeholder 입력창 힌트
 * @param leadingIcon 입력창 시작 아이콘
 * @param trailingIcon 입력창 끝 아이콘
 * @param supportingText 입력창 밑에 표시되는 텍스트
 * @param isError 입력창에 에러 상태 전달. 입력창 테두리가 빨간 색으로 변경됨
 * @param keyboardOptions 입력창 키보드 옵션. KeyboardType, ImeAction 등
 * @param keyboardActions 입력창 키보드 액션. Done, Next, Search 등
 */
@Composable
fun LangChatInputField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String = "",
    placeholder: String = "",
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    supportingText: String = "",
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = label,
            style = LangChatTypography.labelMedium,
        )
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            placeholder = {
                Text(
                    text = placeholder,
                    style = LangChatTypography.bodyMedium,
                )
            },
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            supportingText = {
                Text(
                    text = supportingText,
                    style = LangChatTypography.labelMedium,
                )
            },
            isError = isError,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = true,
        )
    }
}

@Preview
@Composable
private fun LangChatInputFieldPreview() {
    LangChatTheme {
        LangChatInputField(
            value = "",
            onValueChange = {},
            label = "Label",
            leadingIcon = {
                Icon(
                    imageVector = LangChatIcons.Search,
                    contentDescription = null,
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_eye),
                    contentDescription = null,
                )
            },
            supportingText = "Helper text",
        )
    }
}