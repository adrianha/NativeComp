//
//  RCTWrapperViewManager.h
//  NativeComp
//
//  Created by adrian.hartanto on 16/12/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import <React/RCTViewManager.h>

@class RCTWrapperView;

NS_ASSUME_NONNULL_BEGIN

@interface RCTWrapperViewManager : RCTViewManager

- (RCTWrapperView *)view NS_REQUIRES_SUPER;

@end

NS_ASSUME_NONNULL_END
